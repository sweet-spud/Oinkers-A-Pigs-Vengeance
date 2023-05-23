package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.armor.CarrotArmor;
import com.CAIT.oinkers.armor.LevitatingBoots;
import com.CAIT.oinkers.item.CarrotRod;
import com.CAIT.oinkers.item.CarrotShank;
import com.CAIT.oinkers.item.FlyingBoatItem;
import com.CAIT.oinkers.item.ModArmorMaterials;
import com.CAIT.oinkers.item.ModTiers;
import com.CAIT.oinkers.item.PigMedallion;
import com.CAIT.oinkers.item.SpringRod;
import com.google.common.base.Supplier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, oinkers.MOD_ID);
	
	public static final RegistryObject<Item> CARROT_SHANK = register("carrot_shank", 
			() -> new CarrotShank(Tiers.GOLD, 3, 0.75f, new Item.Properties().tab(oinkers.TAB).fireResistant().stacksTo(1).durability(8)
					.food(new FoodProperties.Builder().nutrition(6).saturationMod(2).build())));
	
	
	/**
	 * Various carrots
	 */
	public static final RegistryObject<Item> PIG_MEDALLION = register("pig_medallion", 
			() -> new PigMedallion(new Item.Properties().fireResistant().tab(oinkers.TAB)));
	

	public static final RegistryObject<Item> STONE_CARROT = register("stone_carrot", () -> new ItemNameBlockItem(BlockInit.STONE_CARROT_PLANT.get(), 
			new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1)
					.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0) , 1)
					.alwaysEat().build())));
	
	public static final RegistryObject<Item> IRON_CARROT = register("iron_carrot", 
			() -> new ItemNameBlockItem(BlockInit.IRON_CARROT_PLANT.get(), 
					new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), 1).alwaysEat().build())));
	
	public static final RegistryObject<Item> GOLD_CARROT = register("gold_carrot", 
			() -> new ItemNameBlockItem(BlockInit.GOLD_CARROT_PLANT.get(), new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder()
					.nutrition(8)
					.saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1)
					.alwaysEat().build())));
	
	public static final RegistryObject<Item> DIAMOND_CARROT = register("diamond_carrot", 
			() -> new ItemNameBlockItem(BlockInit.DIAMOND_CARROT_PLANT.get(), new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder()
					.nutrition(10)
					.saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1), 1)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1)
					.alwaysEat().build())));
	


	
	public static final RegistryObject<Item> CARROT_ROD_OF_LIGHT_1 = register("carrot_rod_of_light_1", 
			() -> new CarrotRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_LIGHT_2 = register("carrot_rod_of_light_2", 
			() -> new CarrotRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_LIGHT_3 = register("carrot_rod_of_light_3", 
			() -> new CarrotRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_FIRE_1 = register("carrot_rod_of_fire_1", 
			() -> new CarrotRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_FIRE_2 = register("carrot_rod_of_fire_2", 
			() -> new CarrotRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_FIRE_3 = register("carrot_rod_of_fire_3", 
			() -> new CarrotRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_SPRING_1 = register("carrot_rod_of_spring_1", 
			() -> new SpringRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_SPRING_2 = register("carrot_rod_of_spring_2", 
			() -> new SpringRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	
	public static final RegistryObject<Item> CARROT_ROD_OF_SPRING_3 = register("carrot_rod_of_spring_3", 
			() -> new SpringRod(new Item.Properties().tab(oinkers.TAB).durability(500)));	




	public static final RegistryObject<ArmorItem> LEVITATING_BOOTS = register("levitating_boots",		
			() -> new LevitatingBoots(ArmorMaterials.CHAIN, EquipmentSlot.FEET, 
			new Item.Properties().tab(oinkers.TAB)));
	
	
	
	/**
	 * Carrot ore
	 */
	public static final RegistryObject<Item> CARROT_SHARD = register("carrot_shard", () -> new Item(new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Item> CARROT_INGOT = register("carrot_ingot", () -> new Item(new Item.Properties().tab(oinkers.TAB)));
	
	
	/**
	 * Carrot tools
	 */
	public static final RegistryObject<SwordItem> CARROT_SWORD = register("carrot_sword", 
			() -> new SwordItem(ModTiers.CARROT, 8, .5f, new Item.Properties().tab(oinkers.TAB)));	// first int attack dam, second is speed
	public static final RegistryObject<PickaxeItem> CARROT_PICK = register("carrot_pick",
			() -> new PickaxeItem(ModTiers.CARROT, 4, .5f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<ShovelItem> CARROT_SHOVEL = register("carrot_shovel",	
			() -> new ShovelItem(ModTiers.CARROT, 2, .5f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<AxeItem> CARROT_AXE = register("carrot_axe",
			() -> new AxeItem(ModTiers.CARROT, 10, .3f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<HoeItem> CARROT_HOE = register("carrot_hoe",		// <---- Seth
			() -> new HoeItem(ModTiers.CARROT, 2, .5f, new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<Item> CARROT_SIGN = register("carrot_sign", 
			() -> new SignItem(new Item.Properties().stacksTo(16).tab(oinkers.TAB), 
					BlockInit.CARROT_SIGN.get(), BlockInit.CARROT_WALL_SIGN.get()));
	
	/**
	 * Carrot armor
	 */
	public static final RegistryObject<CarrotArmor> CARROT_HELMET = register("carrot_helmet",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.HEAD, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<CarrotArmor> CARROT_CHEST = register("carrot_chest",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.CHEST, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<CarrotArmor> CARROT_LEGS = register("carrot_legs",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.LEGS, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<CarrotArmor> CARROT_BOOTS = register("carrot_boots",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.FEET, 
			new Item.Properties().tab(oinkers.TAB)));
	
	
	public static final RegistryObject<Item> FLYING_BOAT_ITEM = ITEMS.register("flying_boat_item",
            () -> new FlyingBoatItem(new Item.Properties().tab(oinkers.TAB)));
	
	
	/**
	 * Spawn Eggs
	 */
	public static final RegistryObject<ForgeSpawnEggItem> WIGGLER_SPAWN_EGG = ITEMS.register("wiggler_spawn_egg", 
			() -> new ForgeSpawnEggItem(ModEntityTypes.WIGGLER, 25514528, 25518348, 
					new Item.Properties().tab(oinkers.TAB)));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
	
}
