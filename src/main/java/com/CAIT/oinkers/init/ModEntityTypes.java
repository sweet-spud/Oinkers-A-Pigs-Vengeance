package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.FlyingBoatEntity;
import com.CAIT.oinkers.entity.custom.GoldShardEntity;
import com.CAIT.oinkers.entity.custom.IronShardEntity;
import com.CAIT.oinkers.entity.custom.WigglerEntity;
import com.CAIT.oinkers.entity.custom.pig.GoldPigEntity;
import com.CAIT.oinkers.entity.custom.pig.IronPigEntity;
import com.CAIT.oinkers.entity.custom.pig.StonePigEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, oinkers.MOD_ID);
	
	public static final RegistryObject<EntityType<WigglerEntity>> WIGGLER = ENTITY_TYPES.register("wiggler",
			() -> EntityType.Builder.of(WigglerEntity::new, MobCategory.CREATURE)
			.sized(1f, 2.4f)
			.build(new ResourceLocation(oinkers.MOD_ID, "wiggler").toString()));
	
	public static final RegistryObject<EntityType<StonePigEntity>> STONE_PIG = ENTITY_TYPES.register("stone_pig",
			() -> EntityType.Builder.of(StonePigEntity::new, MobCategory.MONSTER)
			.sized(1.5f, 1.5f)
			.build(new ResourceLocation(oinkers.MOD_ID, "stone_pig").toString()));
	
	public static final RegistryObject<EntityType<IronPigEntity>> IRON_PIG = ENTITY_TYPES.register("iron_pig",
			() -> EntityType.Builder.of(IronPigEntity::new, MobCategory.MONSTER)
			.sized(1f, 1f)
			.build(new ResourceLocation(oinkers.MOD_ID, "iron_pig").toString()));
	
	public static final RegistryObject<EntityType<GoldPigEntity>> GOLD_PIG = ENTITY_TYPES.register("gold_pig", 
			() -> EntityType.Builder.of(GoldPigEntity::new, MobCategory.MONSTER)
			.sized(1.5f, 1.3f)
			.build(new ResourceLocation(oinkers.MOD_ID, "gold_pig").toString()));
	
	public static final RegistryObject<EntityType<IronShardEntity>> IRON_SHARD = ENTITY_TYPES.register("iron_shard",
			() -> EntityType.Builder.<IronShardEntity>of(IronShardEntity::new, MobCategory.MISC)
			.sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20)
			.build(new ResourceLocation(oinkers.MOD_ID, "iron_shard").toString()));
	
	public static final RegistryObject<EntityType<GoldShardEntity>> GOLD_SHARD = ENTITY_TYPES.register("gold_shard",
			() -> EntityType.Builder.<GoldShardEntity>of(GoldShardEntity::new, MobCategory.MISC)
			.sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20)
			.build(new ResourceLocation(oinkers.MOD_ID, "gold_shard").toString()));
	
	public static final RegistryObject<EntityType<FlyingBoatEntity>> FLYING_BOAT =
            ENTITY_TYPES.register("flying_boat", 
            		() -> EntityType.Builder.<FlyingBoatEntity>of(FlyingBoatEntity::new, MobCategory.MISC)
            		.sized(1.375f, 0.5625f).build(new ResourceLocation(oinkers.MOD_ID, "flying_boat").toString()));
	
	public static void register(IEventBus bus) {
		ENTITY_TYPES.register(bus);
	}
}
