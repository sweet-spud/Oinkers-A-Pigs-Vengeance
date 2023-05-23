package com.CAIT.oinkers.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

public class LevitatingBoots extends GeoArmorItem implements IAnimatable {

	public LevitatingBoots(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
		super(p_40386_, p_40387_, p_40388_);
	}
	
	@Override
	public boolean isEnchantable(ItemStack pStack) {
		return false;
	}
	
	@SuppressWarnings("removal")
	private AnimationFactory factory = new AnimationFactory(this);

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<LevitatingBoots>(this, "controller", 20, this::predicate));		
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