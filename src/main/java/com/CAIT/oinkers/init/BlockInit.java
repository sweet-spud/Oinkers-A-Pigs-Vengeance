package com.CAIT.oinkers.init;

import java.util.function.Function;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.block.custom.CarrotInfusingStationBlock;
import com.CAIT.oinkers.block.custom.DiamondCarrotBlock;
import com.CAIT.oinkers.block.custom.GoldCarrotBlock;
import com.CAIT.oinkers.block.custom.IronCarrotBlock;
import com.CAIT.oinkers.block.custom.ModFlammableRotatedPillarBlock;
import com.CAIT.oinkers.block.custom.ModStandingSignBlock;
import com.CAIT.oinkers.block.custom.ModWallSignBlock;
import com.CAIT.oinkers.block.custom.StoneCarrotBlock;
import com.CAIT.oinkers.item.ModWoodTypes;
import com.CAIT.oinkers.world.feature.tree.CarrotTreeGrower;
import com.google.common.base.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, oinkers.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	
	public static final RegistryObject<Block> CARROT_GRASS = register("carrot_grass", () -> new GrassBlock
			(BlockBehaviour.Properties.of(
					Material.DIRT, 
					MaterialColor.COLOR_BROWN)
					.strength(1.0f)
					.sound(SoundType.ROOTED_DIRT)
					), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	public static final RegistryObject<Block> CARROT_DIRT = register("carrot_dirt", () -> new Block
			(BlockBehaviour.Properties.of(
					Material.DIRT, 
					MaterialColor.COLOR_BROWN)
					.strength(1.0f)
					.sound(SoundType.ROOTED_DIRT)
					), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
		
	
	public static final RegistryObject<Block> CARROT_STONE = register("carrot_stone", () -> new Block
			(BlockBehaviour.Properties.copy(Blocks.STONE)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   public static final RegistryObject<Block> CARROT_STONE_STAIRS = register("carrot_stone_stairs", 
			   () -> new StairBlock(CARROT_STONE.get()::defaultBlockState, 
					   BlockBehaviour.Properties.copy(Blocks.STONE)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   public static final RegistryObject<Block> CARROT_STONE_SLAB = register("carrot_stone_slab", 
			   () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   public static final RegistryObject<Block> CARROT_STONE_WALL = register("carrot_stone_wall", 
			   () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	   public static final RegistryObject<Block> CARROT_STONE_BUTTON = register("carrot_stone_button", 
			   () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   public static final RegistryObject<Block> CARROT_STONE_PRESSURE_PLATE = register("carrot_stone_pressure_plate", 
			   () -> new PressurePlateBlock(Sensitivity.MOBS, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   
	public static final RegistryObject<Block> CARROT_COBBLESTONE = register("carrot_cobblestone", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   public static final RegistryObject<Block> CARROT_COBBLESTONE_STAIRS = register("carrot_cobblestone_stairs", 
			   () -> new StairBlock(CARROT_COBBLESTONE.get()::defaultBlockState, 
					   BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   public static final RegistryObject<Block> CARROT_COBBLESTONE_SLAB = register("carrot_cobblestone_slab", 
			   () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	   public static final RegistryObject<Block> CARROT_COBBLESTONE_WALL = register("carrot_cobblestone_wall", 
			   () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)),
			   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));

	
	
	public static final RegistryObject<Block> CARROT_LOG = register("carrot_log", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Block> CARROT_WOOD = register("carrot_wood", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Block> STRIPPED_CARROT_LOG = register("stripped_carrot_log", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Block> STRIPPED_CARROT_WOOD = register("stripped_carrot_wood", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	public static final RegistryObject<Block> CARROT_PLANKS = register("carrot_planks", () -> new Block
			(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()) {
		
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }
        
        
    },	object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
   public static final RegistryObject<Block> CARROT_STAIRS = register("carrot_stairs", 
		   () -> new StairBlock(CARROT_PLANKS.get()::defaultBlockState, 
				   BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   public static final RegistryObject<Block> CARROT_SLAB = register("carrot_slab", 
		   () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_SLAB)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   public static final RegistryObject<Block> CARROT_FENCE = register("carrot_fence", 
		   () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   public static final RegistryObject<Block> CARROT_FENCE_GATE = register("carrot_fence_gate", 
		   () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE_GATE)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   
   public static final RegistryObject<Block> CARROT_BUTTON = register("carrot_button", 
		   () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_BUTTON)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   public static final RegistryObject<Block> CARROT_PRESSURE_PLATE = register("carrot_pressure_plate", 
		   () -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.BIRCH_PRESSURE_PLATE)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   public static final RegistryObject<Block> CARROT_DOOR = register("carrot_door", 
		   () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_DOOR)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   public static final RegistryObject<Block> CARROT_TRAPDOOR = register("carrot_trapdoor", 
		   () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR)),
		   object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
   
   public static final RegistryObject<Block> CARROT_WALL_SIGN = registerBlockWithoutItem("carrot_wall_sign", 
		   () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CARROT));
   public static final RegistryObject<Block> CARROT_SIGN = registerBlockWithoutItem("carrot_sign", 
		   () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CARROT));
   
	
	public static final RegistryObject<Block> CARROT_LEAVES = register("carrot_leaves", () -> new LeavesBlock
			(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()){
				
				
		        @Override
		        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		            return true;
		        }

		        @Override
		        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		            return 30;
		        }

		        @Override
		        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		            return 60;
		        }
		        
		        
		    }, 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<Block> CARROT_SAPLING = register("carrot_sapling", () -> new SaplingBlock
			(new CarrotTreeGrower() ,BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	// Carrot block
	public static final RegistryObject<Block> CARROT_BLOCK = register("carrot_block", () -> new Block(BlockBehaviour.Properties.of(
			Material.HEAVY_METAL,
			MaterialColor.COLOR_ORANGE)
			.strength(7)), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	
	// Carrot Juice
	public static final RegistryObject<LiquidBlock> PIG_JUICE_BLOCK = BLOCKS.register("pig_juice_block", 
			() -> new LiquidBlock(FluidInit.PIG_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
	
	
	public static final RegistryObject<Block> CARROT_ORE = register("carrot_ore", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops()), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	
	// Custom Entity Block
	public static final RegistryObject<Block> CARROT_INFUSING_STATION = register("carrot_infusing_station", 
			() -> new CarrotInfusingStationBlock(BlockBehaviour.Properties.of(Material.METAL)
					.strength(6f)
					.noOcclusion()
					.requiresCorrectToolForDrops()), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	// Carrot Crops
	
	public static final RegistryObject<Block> STONE_CARROT_PLANT = registerBlockWithoutItem("stone_carrot_plant",
            () -> new StoneCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
    public static final RegistryObject<Block> IRON_CARROT_PLANT = registerBlockWithoutItem("iron_carrot_plant",
            () -> new IronCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
    public static final RegistryObject<Block> GOLD_CARROT_PLANT = registerBlockWithoutItem("gold_carrot_plant",
            () -> new GoldCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
    public static final RegistryObject<Block> DIAMOND_CARROT_PLANT = registerBlockWithoutItem("diamond_carrot_plant",
            () -> new DiamondCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
	
	
    
	private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends  Item>> item) {
		RegistryObject<T> obj = registerBlockWithoutItem(name, block);
		ITEMS.register(name, item.apply(obj));
		
		return (obj);
	}	
	
}
