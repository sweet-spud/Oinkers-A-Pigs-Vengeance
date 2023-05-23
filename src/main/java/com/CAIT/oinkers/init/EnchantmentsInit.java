package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.enchantment.Absorption;
import com.CAIT.oinkers.enchantment.Speed;
import com.CAIT.oinkers.enchantment.Strength;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentsInit {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, oinkers.MOD_ID);
	
	public static RegistryObject<Enchantment> ABSORPTION = 
			ENCHANTMENTS.register("absorption", 
					() -> new Absorption(Enchantment.Rarity.COMMON,
							EnchantmentCategory.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	
	public static RegistryObject<Enchantment> SPEED = 
			ENCHANTMENTS.register("speed", 
					() -> new Speed(Enchantment.Rarity.COMMON,
							EnchantmentCategory.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	
	public static RegistryObject<Enchantment> STRENGTH = 
			ENCHANTMENTS.register("strength", 
					() -> new Strength(Enchantment.Rarity.COMMON,
							EnchantmentCategory.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	
	
	public static void register(IEventBus bus) {
		ENCHANTMENTS.register(bus);
	}
}
