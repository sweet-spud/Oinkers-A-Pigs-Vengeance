package com.CAIT.oinkers.entity.client.armor;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.armor.CarrotArmor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CarrotArmorModel extends AnimatedGeoModel<CarrotArmor>{

	@Override
	public ResourceLocation getAnimationResource(CarrotArmor animatable) {
		// TODO Auto-generated method stub
		return new ResourceLocation(oinkers.MOD_ID, "animations/carrot_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CarrotArmor object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(oinkers.MOD_ID, "geo/carrot_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CarrotArmor object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(oinkers.MOD_ID, "textures/models/armor/carrot_armor_texture.png");
	}

}
