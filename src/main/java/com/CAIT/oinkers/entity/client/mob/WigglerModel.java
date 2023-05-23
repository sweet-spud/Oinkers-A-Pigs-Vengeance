package com.CAIT.oinkers.entity.client.mob;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.WigglerEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WigglerModel extends AnimatedGeoModel<WigglerEntity>{

	@Override
	public ResourceLocation getAnimationResource(WigglerEntity animatable) {
		return new ResourceLocation(oinkers.MOD_ID, "animations/wiggler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WigglerEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "geo/wiggler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WigglerEntity object) {
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/wiggler/wiggler.png");
	}

}
