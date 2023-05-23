package com.CAIT.oinkers.init;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.MobSpawnSettings.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.api.biome.ModBiomeFeatures;

public class BiomeInit {
	
	protected static int calculateSkyColor(float color)
    {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }	
	
	private static Builder SpawnSettings() {
		// Mod Spawn Settings
				MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
				BiomeDefaultFeatures.commonSpawns(spawnBuilder);
				
		return spawnBuilder;
	}
	private static BiomeGenerationSettings.Builder GenSettings() {
		// Biome features
				BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
				globalOverworldGeneration(biomeBuilder);
		        
		return biomeBuilder;
	}
	
	
	
	 public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, oinkers.MOD_ID);
	 
	 public static final RegistryObject<Biome> CARROT_LAND = register("carrot_land", () -> new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
				.temperature(0.6F)
				.downfall(0.9F)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(0x62AF84)
						.waterFogColor(0x0C211C)
						.fogColor(12638463)
						.skyColor(calculateSkyColor(0.4F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.backgroundMusic(null).build())
				.mobSpawnSettings(SpawnSettings().build())
				.generationSettings(GenSettings().build()).build());
				
				
	private static <T extends Biome> RegistryObject<T> register(final String name, final Supplier<? extends T> Biome){
		return BIOMES.register(name, Biome);
	}
	 
	 
	 
	 private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder)
	    {
	        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
	        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
	        ModBiomeFeatures.addSprings(builder);
	        BiomeDefaultFeatures.addSurfaceFreezing(builder);
	    }

}
