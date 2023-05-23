package com.CAIT.oinkers.entity.client.armor;

import com.CAIT.oinkers.armor.CarrotArmor;

import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CarrotArmorRenderer extends GeoArmorRenderer<CarrotArmor>{

	public CarrotArmorRenderer() {
		super(new CarrotArmorModel());
		
		this.headBone = "armorHead";
		this.bodyBone = "armorBody";
		this.rightArmBone = "armorRightArm";
		this.leftArmBone = "armorLeftArm";
		this.leftLegBone = "armorLeftLeg";
		this.rightLegBone = "armorRightLeg";
		this.leftBootBone = "armorLeftBoot";
		this.rightBootBone = "armorRightBoot";
	}

	
}
/**
this.headBone = "armorHead";
this.bodyBone = "armorBody";
this.rightArmBone = "armorRightArm";
this.leftArmBone = "armorLeftArm";
this.rightLegBone = "armorLeftLeg";
this.leftLegBone = "armorRightLeg";
this.rightBootBone = "armorLeftBoot";
this.leftBootBone = "armorRightBoot";
**/