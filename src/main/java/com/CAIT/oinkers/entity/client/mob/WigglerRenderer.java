package com.CAIT.oinkers.entity.client.mob;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.WigglerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WigglerRenderer extends GeoEntityRenderer<WigglerEntity>{

	public WigglerRenderer(Context renderManager) {
		super(renderManager, new WigglerModel());	
		this.shadowRadius = 1;
	}
	
	@Override
	public ResourceLocation getTextureLocation(WigglerEntity animatable) {
		// TODO Auto-generated method stub
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/wiggler/wiggler.png");
	}
	
	@Override
	public RenderType getRenderType(WigglerEntity animatable, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		if (animatable.isBaby()) {
			poseStack.scale(2f, 1.5f, 1.5f);
		}
		else {	
			poseStack.scale(3.2f, 3.2f, 3.2f);	// Scale model
		}
		if (animatable.goalSelector.getRunningGoals().anyMatch((goal) -> goal.getGoal() instanceof PanicGoal)) {
			System.out.println("here");
		}
		return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
	}

}
