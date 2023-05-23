package com.CAIT.oinkers.entity.client.mob;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.pig.GoldPigEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldPigModel extends AnimatedGeoModel<GoldPigEntity>{

	@Override
	public ResourceLocation getAnimationResource(GoldPigEntity animatable) {
		return new ResourceLocation(oinkers.MOD_ID, "animations/gold_pig.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldPigEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "geo/gold_pig.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldPigEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/gold_pig/gold_pig.png");
	}

}
