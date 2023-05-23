package com.CAIT.oinkers.api.biome;

import com.CAIT.oinkers.init.BlockInit;
import com.CAIT.oinkers.init.FluidInit;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModBiomeFeatures extends BiomeDefaultFeatures{
	
	public static final Holder<ConfiguredFeature<SpringConfiguration, ?>> SPRING_PIG_JUICE_CONFIG = FeatureUtils.register("spring_pig_juice", Feature.SPRING, new SpringConfiguration(FluidInit.PIG_JUICE.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, BlockInit.CARROT_STONE.get(), Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT, Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW, Blocks.PACKED_ICE)));
	
	public static final Holder<PlacedFeature> SPRING_PIG_JUICE = PlacementUtils.register("spring_pig_juice", SPRING_PIG_JUICE_CONFIG, CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)), BiomeFilter.biome());

	public static void addSprings(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, SPRING_PIG_JUICE);
	    builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_LAVA);
	   }
	
}
