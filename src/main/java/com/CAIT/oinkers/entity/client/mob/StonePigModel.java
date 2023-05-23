package com.CAIT.oinkers.entity.client.mob;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.pig.StonePigEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StonePigModel extends AnimatedGeoModel<StonePigEntity>{

	@Override
	public ResourceLocation getAnimationResource(StonePigEntity animatable) {
		return new ResourceLocation(oinkers.MOD_ID, "animations/stone_pig.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StonePigEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "geo/stone_pig.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StonePigEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/stone_pig/stone_pig.png");
	}

}
