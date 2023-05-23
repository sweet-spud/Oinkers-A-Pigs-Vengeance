package com.CAIT.oinkers.entity.client.mob;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.pig.GoldPigEntity;
import com.CAIT.oinkers.entity.custom.pig.IronPigEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GoldPigRenderer extends GeoEntityRenderer<GoldPigEntity>{

	public GoldPigRenderer(Context renderManager) {
		super(renderManager, new GoldPigModel());
		this.shadowRadius = 1.2f;
	}
	
	@Override
	public ResourceLocation getTextureLocation(GoldPigEntity animatable) {
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/gold_pig/gold_pig.png");
	}
	
	@Override
	public RenderType getRenderType(GoldPigEntity animatable, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		poseStack.scale(1.5f, 1.5f, 1.5f);	// Scale model
		return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
	}

}
