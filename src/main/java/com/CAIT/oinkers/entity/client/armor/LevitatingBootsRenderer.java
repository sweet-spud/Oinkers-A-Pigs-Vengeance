package com.CAIT.oinkers.entity.client.armor;

import com.CAIT.oinkers.armor.LevitatingBoots;

import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class LevitatingBootsRenderer extends GeoArmorRenderer<LevitatingBoots> {

	public LevitatingBootsRenderer() {
		super(new LevitatingBootsModel());
		this.leftBootBone = "armorLeftBoot";
		this.rightBootBone = "armorRightBoot";
	}
}
