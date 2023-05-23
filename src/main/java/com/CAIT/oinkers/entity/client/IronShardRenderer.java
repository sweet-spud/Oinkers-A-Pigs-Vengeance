package com.CAIT.oinkers.entity.client;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.IronShardEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class IronShardRenderer extends ArrowRenderer<IronShardEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(oinkers.MOD_ID, "textures/entity/projectiles/iron_shard.png");
	
	public IronShardRenderer(Context pContext) {
		super(pContext);
	}

	@Override
	public ResourceLocation getTextureLocation(IronShardEntity pEntity) {
		return TEXTURE;
	}

} //https://github.com/InventivetalentDev/minecraft-assets/tree/1.19.2
