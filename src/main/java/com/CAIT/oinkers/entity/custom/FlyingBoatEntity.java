package com.CAIT.oinkers.entity.custom;

import com.CAIT.oinkers.init.BlockInit;
import com.CAIT.oinkers.init.FluidInit;
import com.CAIT.oinkers.init.ItemInit;
import com.CAIT.oinkers.init.ModEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class FlyingBoatEntity extends Boat {

	public FlyingBoatEntity(EntityType<? extends Boat> p_38290_, Level p_38291_) {
		super(p_38290_, p_38291_);
	}

	public FlyingBoatEntity(Level level, double p_38294_, double p_38295_, double p_38296_) {
		this(ModEntityTypes.FLYING_BOAT.get(), level);
	      this.setPos(p_38294_, p_38295_, p_38296_);
	      this.xo = p_38294_;
	      this.yo = p_38295_;
	      this.zo = p_38296_;
	}

	@Override
	public Item getDropItem() {
		return ItemInit.FLYING_BOAT_ITEM.get();
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
        return new ItemStack((ItemLike)this.getDropItem());
	}

	 @Override
	public Packet<?> getAddEntityPacket() {
		 return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
	}

	 @Override
	public float getWaterLevelAbove() {
		return super.getWaterLevelAbove();
	}

	 @Override
	public boolean canBoatInFluid(FluidState state) {
		if (state.is(FluidInit.PIG_JUICE.get()) || state.is(FluidInit.FLOWING_PIG_JUICE.get())) {
			return true;
		}
		else if (state.is(Fluids.WATER) || state.is(Fluids.FLOWING_WATER)) {
			return true;
		}
		return false;
	}

	@Override
	protected float getBlockSpeedFactor() {
		BlockState blockstate = this.level.getBlockState(this.blockPosition());
		if (!(blockstate.is(BlockInit.PIG_JUICE_BLOCK.get()))) {
			return 1;
		}
		return 1.1f;
	}
}