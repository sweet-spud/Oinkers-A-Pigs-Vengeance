package com.CAIT.oinkers.armor;

import java.util.HashMap;

import com.CAIT.oinkers.init.EnchantmentsInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

public class CarrotArmor extends GeoArmorItem implements IAnimatable{
	
	public CarrotArmor(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
	}
// adjust delay
	private static int lastTickAbsorption = 0;
	private static int lastTickSpeed = 0;
	private static int lastTickStrength = 0;
	
	@SuppressWarnings("removal")
	private AnimationFactory factory = new AnimationFactory(this);

	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		if (!(world.isClientSide())) {
			HashMap<String, Integer> MobEffectsMap = new HashMap<String, Integer>();
			MobEffectsMap.put("Absorption", 0);
			MobEffectsMap.put("Speed", 0);
			MobEffectsMap.put("Strength", 0);
			MobEffectsMap = evaluateArmor(MobEffectsMap, player);
			if (!(player.getActiveEffectsMap().containsKey(MobEffects.ABSORPTION))) {
				if (lastTickAbsorption > 0) {
					lastTickAbsorption--;
				} else {
					switch (MobEffectsMap.get("Absorption")) {
					case (1): {
						player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0));
						lastTickAbsorption = 1200; // 60 seconds			// 60 seconds
						break;
					}
					case (2): {
						player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1800, 0));
						lastTickAbsorption = 600; // 30 seconds				// 180 seconds
						break;
					}
					case (3): {
						player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1800, 1));
						lastTickAbsorption = 300; // 15 seconds				//180 seconds
						break;
					}
					case (4): {
						player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1));
						lastTickAbsorption = 0;
						break;
					}
					}
				}
			}
			if (!(player.getActiveEffectsMap().containsKey(MobEffects.MOVEMENT_SPEED))) {
				if (lastTickSpeed > 0) {
					lastTickSpeed--;
				} else {
					switch (MobEffectsMap.get("Speed")) {
					case (1): {
						player.addEffect(
								new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0));
						lastTickSpeed = 600; // 30 seconds 				// 10 seconds
						break;
					}
					case (2): {
						player.addEffect(
								new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0));
						lastTickSpeed = 300; // 15 seconds				// 15 seconds
						break;
					}
					case (3): {
						player.addEffect(
								new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1));
						lastTickSpeed = 200; // 10 seconds				// 20 seconds
						break;
					}
					case (4): {
						player.addEffect(
								new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
						lastTickSpeed = 0;
						break;
					}
					}
				}
			}
			if (!(player.getActiveEffectsMap().containsKey(MobEffects.DAMAGE_BOOST))) {
				if (lastTickStrength > 0) {
					lastTickStrength--;
				} else {
					switch (MobEffectsMap.get("Strength")) {
					case (1): {
						player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0));
						lastTickStrength = 600;
						break;
					}
					case (2): {
						player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0));
						lastTickStrength = 300;
						break;
					}
					case (3): {
						player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 1));
						lastTickStrength = 200;
						break;
					}
					case (4): {
						player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
						lastTickStrength = 0;
						break;
					}
					}
				}
			}

		}
	}

	private HashMap<String, Integer> evaluateArmor(HashMap<String, Integer> MobEffectsMap, Player player) {
		if (!(player.getInventory().getArmor(0).isEmpty())) {
			MobEffectsMap = evaluateEnchantments(0, MobEffectsMap, player);
		}
		if (!(player.getInventory().getArmor(1).isEmpty())) {
			MobEffectsMap = evaluateEnchantments(1, MobEffectsMap, player);
		}
		if (!(player.getInventory().getArmor(2).isEmpty())) {
			MobEffectsMap = evaluateEnchantments(2, MobEffectsMap, player);
		}
		if (!(player.getInventory().getArmor(3).isEmpty())) {
			MobEffectsMap = evaluateEnchantments(3, MobEffectsMap, player);
		}
		return MobEffectsMap;
	}

	private HashMap<String, Integer> evaluateEnchantments(int slot, HashMap<String, Integer> MobEffectsMap,
			Player player) {
		if (player.getInventory().getArmor(slot).getAllEnchantments()
				.containsKey(EnchantmentsInit.ABSORPTION.get())) {
			MobEffectsMap.put("Absorption", MobEffectsMap.get("Absorption") + 1);
		} 
		else if (player.getInventory().getArmor(slot).getAllEnchantments()
				.containsKey(EnchantmentsInit.SPEED.get())) {
			MobEffectsMap.put("Speed", MobEffectsMap.get("Speed") + 1);
		} 
		else if (player.getInventory().getArmor(slot).getAllEnchantments()
				.containsKey(EnchantmentsInit.STRENGTH.get())) {
			MobEffectsMap.put("Strength", MobEffectsMap.get("Strength") + 1);
		}
		return (MobEffectsMap);
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<CarrotArmor>(this, "controller", 20, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	@SuppressWarnings("removal")
	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.carrot_armor.idle", true));
		return PlayState.CONTINUE;
	}
}
