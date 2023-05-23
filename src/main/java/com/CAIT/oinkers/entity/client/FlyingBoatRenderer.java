package com.CAIT.oinkers.entity.client;

import com.CAIT.oinkers.oinkers;
import com.mojang.datafixers.util.Pair;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public class FlyingBoatRenderer extends BoatRenderer{

	public static final ModelLayerLocation LOCATION = new ModelLayerLocation(new ResourceLocation(oinkers.MOD_ID, "flying_boat"), "main");
	private final Pair<ResourceLocation, BoatModel> model;

	public FlyingBoatRenderer(EntityRendererProvider.Context dispatcher) {
	    super(dispatcher, false);
	    model = Pair.of(new ResourceLocation(oinkers.MOD_ID, "textures/entity/boat/flying_boat.png"), 
	    		new BoatModel(dispatcher.bakeLayer(LOCATION), false));
	}

	public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
	    return model;
	}
}