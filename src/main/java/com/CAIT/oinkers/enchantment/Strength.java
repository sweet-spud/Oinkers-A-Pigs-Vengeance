package com.CAIT.oinkers.enchantment;

import com.CAIT.oinkers.init.EnchantmentsInit;
import com.CAIT.oinkers.item.ModArmorMaterials;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Strength extends Enchantment{

	public Strength(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slot) {
		super(rarity, category, slot);
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		if ((enchantment.equals(EnchantmentsInit.SPEED.get())) || (enchantment.equals(EnchantmentsInit.ABSORPTION.get()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean canEnchant(ItemStack item) {
		if (((ArmorItem)item.getItem()).getMaterial() == ModArmorMaterials.CARROT) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getMinCost(int pLevel) {
		return 30;
	}
	
	@Override
	public boolean isDiscoverable() {
		return true;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean isTradeable() {
		return false;
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
}
