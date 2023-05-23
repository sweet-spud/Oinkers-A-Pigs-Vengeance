package com.CAIT.oinkers.api.biome;


import com.CAIT.oinkers.oinkers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class OinkersBiomes {
	
	private static List<ResourceKey<Biome>> BIOMES = Lists.newArrayList();
	
	
	public static final ResourceKey<Biome> CARROT_LAND = registerBiome("carrot_land");
	
	
	private static ResourceKey<Biome> registerBiome(String name)
    {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(oinkers.MOD_ID, name));
        BIOMES.add(key);
        return key;
    }
	
	
}
