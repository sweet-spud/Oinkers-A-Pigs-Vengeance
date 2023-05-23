package com.CAIT.oinkers.entity.client.mob;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.pig.IronPigEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IronPigModel extends AnimatedGeoModel<IronPigEntity>{

	@Override
	public ResourceLocation getAnimationResource(IronPigEntity animatable) {
		return new ResourceLocation(oinkers.MOD_ID, "animations/iron_pig.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IronPigEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "geo/iron_pig.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IronPigEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/iron_pig/iron_pig.png");
	}

}
