package com.CAIT.oinkers.entity.client.armor;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.armor.LevitatingBoots;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LevitatingBootsModel extends AnimatedGeoModel<LevitatingBoots> {

	@Override
	public ResourceLocation getAnimationResource(LevitatingBoots animatable) {
		return new ResourceLocation(oinkers.MOD_ID, "animations/carrot_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LevitatingBoots object) {
		return new ResourceLocation(oinkers.MOD_ID, "geo/levitating_boots.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LevitatingBoots object) {
		return new ResourceLocation(oinkers.MOD_ID, "textures/models/armor/levitating_boots_texture.png");
	}

}
