package com.CAIT.oinkers.world.dimension;

import com.CAIT.oinkers.oinkers;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {

	public static final ResourceKey<Level> DIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
			new ResourceLocation(oinkers.MOD_ID, "dim"));
	
	public static final ResourceKey<DimensionType> DIM_TYPE =
			ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, 
					new ResourceLocation(oinkers.MOD_ID, "dim"));
	
	
	public static void register() {
		System.out.print("Registering ModDimensions for " + oinkers.MOD_ID);
	}

}
