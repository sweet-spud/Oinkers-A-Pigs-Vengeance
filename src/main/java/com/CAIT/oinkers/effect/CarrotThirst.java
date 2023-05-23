package com.CAIT.oinkers.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.block.Rotation;

public class CarrotThirst extends MobEffect{

	public CarrotThirst(MobEffectCategory effectCategory, int color) {
		super(effectCategory, color);
	}
	/**
	 * 
	 * This doesnt do anything now, but im gonna an effect done by the carrot sword later. Still figuring out how to do it.
	 * 
	 */
	 
	@Override
	public void applyEffectTick(LivingEntity entity, int p_19468_) {
		if (!entity.level.isClientSide()) {
			entity.knockback(100, 100, 100);
			entity.rotate(Rotation.CLOCKWISE_180);
			System.out.println("here");
		}
		super.applyEffectTick(entity, p_19468_);
	}
	
	@Override
	public void applyInstantenousEffect(Entity p_19462_, Entity p_19463_, LivingEntity target, int p_19465_,
			double p_19466_) {
		target.knockback(100, 100, 100);
		target.rotate(Rotation.CLOCKWISE_180);
		System.out.println("thing");
		super.applyInstantenousEffect(p_19462_, p_19463_, target, p_19465_, p_19466_);
	}
}
