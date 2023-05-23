package com.CAIT.oinkers.entity.client;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.GoldShardEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class GoldShardRenderer extends ArrowRenderer<GoldShardEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(oinkers.MOD_ID, "textures/entity/projectiles/gold_shard.png");
	
	public GoldShardRenderer(Context pContext) {
		super(pContext);
	}

	@Override
	public ResourceLocation getTextureLocation(GoldShardEntity pEntity) {
		return TEXTURE;
	}

} //https://github.com/InventivetalentDev/minecraft-assets/tree/1.19.2
