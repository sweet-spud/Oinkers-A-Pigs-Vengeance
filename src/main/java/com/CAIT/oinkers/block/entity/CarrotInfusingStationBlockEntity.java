package com.CAIT.oinkers.block.entity;


import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.CAIT.oinkers.recipe.CarrotInfuserRecipe;
import com.CAIT.oinkers.screen.CarrotInfuserMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

@SuppressWarnings("removal")
public class CarrotInfusingStationBlockEntity extends BlockEntity implements MenuProvider{
	
	private final ItemStackHandler itemHandler = new ItemStackHandler(6) {
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
		};
	};

	private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();	
	
	protected final ContainerData data;
	private int progress = 0;
	private int maxProgress = 78;
	
	public CarrotInfusingStationBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntitiesTypes.CARROT_INFUSING_STATION.get(), pos, state);
		this.data = new ContainerData() {
			@Override
			public int get(int index) {
				 return switch (index) {
                 case 0 -> CarrotInfusingStationBlockEntity.this.progress;
                 case 1 -> CarrotInfusingStationBlockEntity.this.maxProgress;
                 default -> 0;
             };
			}
			@Override
			public void set(int index, int value) {
				 switch (index) {
                 case 0 -> CarrotInfusingStationBlockEntity.this.progress = value;
                 case 1 -> CarrotInfusingStationBlockEntity.this.maxProgress = value;
             }
				
			}
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 6;
			}
		};
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
		// TODO Auto-generated method stub
		return new CarrotInfuserMenu(id, inventory, this, this.data);
	}

	@Override
	public Component getDisplayName() {
		// TODO Auto-generated method stub
		return Component.literal("Carrot Infuser");
	}
	
	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {		
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return lazyItemHandler.cast();
		}
		return super.getCapability(cap, side);
	}
	
	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		super.onLoad();
		lazyItemHandler = LazyOptional.of(() -> itemHandler);
	}
	
	@Override
	public void invalidateCaps() {
		// TODO Auto-generated method stub
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}
	
	@Override
	protected void saveAdditional(CompoundTag nbt) {
		nbt.put("inventory", itemHandler.serializeNBT());
		nbt.putInt("carrot_infuser.progress", this.progress);
		
		// TODO Auto-generated method stub
		super.saveAdditional(nbt);
	}
	
	@Override
	public void load(CompoundTag nbt) {
		// TODO Auto-generated method stub
		super.load(nbt);
		itemHandler.deserializeNBT(nbt.getCompound("inventory"));
		progress = nbt.getInt("carrot_infuser.progress");
	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
		for(int i = 0; i<itemHandler.getSlots(); i++) {
			inventory.setItem(i, itemHandler.getStackInSlot(i));
		}
		
		Containers.dropContents(this.level, this.worldPosition, inventory);
	}
	public static void tick(Level level, BlockPos pos, BlockState state, CarrotInfusingStationBlockEntity pEntity) {
		if(level.isClientSide()) {
			return;
		}
		if(hasRecipe(pEntity)) {
			pEntity.progress++;
			setChanged(level, pos, state);
			
			if (pEntity.progress >= pEntity.maxProgress) {
				craftItem(pEntity);
			}
		} 
		else {
			pEntity.resetProgress();
			setChanged(level, pos, state);
		}
	}

	private void resetProgress() {
		this.progress = 0;
		
	}

	private static void craftItem(CarrotInfusingStationBlockEntity pEntity) {		
		Level level = pEntity.level;
		SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
		for(int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
		}
		
		Optional<CarrotInfuserRecipe> recipe = level.getRecipeManager().getRecipeFor(CarrotInfuserRecipe.Type.INSTANCE,inventory , level);
		
		if(hasRecipe(pEntity)) {
			if(pEntity.itemHandler.getStackInSlot(5).isEmpty()) {
				pEntity.itemHandler.extractItem(0, 1, false);
				pEntity.itemHandler.extractItem(1, 1, false);
				pEntity.itemHandler.extractItem(2, 1, false);
				pEntity.itemHandler.extractItem(3, 1, false);
				pEntity.itemHandler.extractItem(4, 1, false);
				pEntity.itemHandler.setStackInSlot(5, new ItemStack(recipe.get().getResultItem().getItem()));
			
				pEntity.resetProgress();			
			}
		}
		
	}

	private static boolean hasRecipe(CarrotInfusingStationBlockEntity pEntity) {
		Level level = pEntity.level;
		SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
		for(int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
		}
		
		Optional<CarrotInfuserRecipe> recipe = level.getRecipeManager().getRecipeFor(CarrotInfuserRecipe.Type.INSTANCE,inventory , level);
		
		return recipe.isPresent() && canInsertAmountIntoOutput(inventory) &&
				canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem());
	}

	private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack itemStack) {
		
		return inventory.getItem(6).getItem() == itemStack.getItem() || inventory.getItem(6).isEmpty();
	}

	private static boolean canInsertAmountIntoOutput(SimpleContainer inventory) {
		
		return inventory.getItem(6).getMaxStackSize() > inventory.getItem(6).getCount();
	}
	
}
