package com.CAIT.oinkers.item;

import java.util.function.Supplier;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.init.ItemInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial {
	   
		   CARROT("carrot", 35, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.0F, 
				   () -> Ingredient.of(ItemInit.CARROT_INGOT.get()));

		   private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
		   private final String name;
		   private final int durabilityMultiplier;
		   private final int[] slotProtections;
		   private final int enchantmentValue;
		   private final SoundEvent sound;
		   private final float toughness;
		   private final float knockbackResistance;
		   private final LazyLoadedValue<Ingredient> repairIngredient;

		   private ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, 
				   float toughness, float knockbackResistance, Supplier<Ingredient> ingrediant) {
		      this.name = name;
		      this.durabilityMultiplier = durabilityMultiplier;
		      this.slotProtections = slotProtections;
		      this.enchantmentValue = enchantmentValue;
		      this.sound = sound;
		      this.toughness = toughness;
		      this.knockbackResistance = knockbackResistance;
		      this.repairIngredient = new LazyLoadedValue<>(ingrediant);
		   }

		   public int getDurabilityForSlot(EquipmentSlot p_40484_) {
		      return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
		   }

		   public int getDefenseForSlot(EquipmentSlot p_40487_) {
		      return this.slotProtections[p_40487_.getIndex()];
		   }

		   public int getEnchantmentValue() {
		      return this.enchantmentValue;
		   }

		   public SoundEvent getEquipSound() {
		      return this.sound;
		   }

		   public Ingredient getRepairIngredient() {
		      return this.repairIngredient.get();
		   }

		   public String getName() {
		      return (oinkers.MOD_ID + ":" + this.name);
		   }

		   public float getToughness() {
		      return this.toughness;
		   }

		   public float getKnockbackResistance() {
		      return this.knockbackResistance;
		   }
	
}
