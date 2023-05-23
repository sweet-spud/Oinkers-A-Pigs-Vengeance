package com.CAIT.oinkers.block.entity;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.init.BlockInit;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntitiesTypes {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = 
			DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, oinkers.MOD_ID);
	
	public static final RegistryObject<BlockEntityType<CarrotInfusingStationBlockEntity>> CARROT_INFUSING_STATION =
			BLOCK_ENTITY_TYPES.register("carrot_infusing_station", 
					()-> BlockEntityType.Builder.of(CarrotInfusingStationBlockEntity::new, 
							BlockInit.CARROT_INFUSING_STATION.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES = BLOCK_ENTITY_TYPES.register("sign_block_entity", 
			() -> BlockEntityType.Builder.of(ModSignBlockEntity::new, 
					BlockInit.CARROT_WALL_SIGN.get(),
					BlockInit.CARROT_SIGN.get()).build(null));
	
	public static void register(IEventBus bus) {
		BLOCK_ENTITY_TYPES.register(bus);
	}
}
