package com.CAIT.oinkers.entity.client.mob;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.pig.IronPigEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class IronPigRenderer extends GeoEntityRenderer<IronPigEntity>{

	public IronPigRenderer(Context renderManager) {
		super(renderManager, new IronPigModel());
		this.shadowRadius = 1.2f;
	}
	
	@Override
	public ResourceLocation getTextureLocation(IronPigEntity animatable) {
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/iron_pig/iron_pig.png");
	}
	
	@Override
	public RenderType getRenderType(IronPigEntity animatable, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		poseStack.scale(1f, 1f, 1f);	// Scale model
		return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
	}

}
