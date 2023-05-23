package com.CAIT.oinkers.init;

import com.CAIT.oinkers.entity.client.FlyingBoatRenderer;

import net.minecraft.client.model.BoatModel;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class BoatClient {
	public static void boatClientOne(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.FLYING_BOAT.get(), FlyingBoatRenderer::new);
    }

    public static void boatClientTwo(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FlyingBoatRenderer.LOCATION, () -> BoatModel.createBodyModel(false));
    }
}