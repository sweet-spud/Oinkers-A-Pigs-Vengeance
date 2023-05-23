package com.CAIT.oinkers.world.feature;

import java.util.List;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.init.BlockInit;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {

	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, oinkers.MOD_ID);
			
			
	public static final Supplier<List<OreConfiguration.TargetBlockState>> CARROT_ORES = Suppliers.memoize(()-> List.of(
			OreConfiguration.target(new BlockMatchTest(BlockInit.CARROT_STONE.get()), BlockInit.CARROT_ORE.get().defaultBlockState())));
	
	public static final RegistryObject<ConfiguredFeature<?,?>> CARROT_ORE = CONFIGURED_FEATURES.register("carrot_ore", () -> new ConfiguredFeature<>(Feature.ORE, 
			new OreConfiguration(CARROT_ORES.get(), 4)));
	
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> CARROT = CONFIGURED_FEATURES.register("carrot", () ->
    
			new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
			        BlockStateProvider.simple(BlockInit.CARROT_LOG.get()),
			        new FancyTrunkPlacer(16, 7, 4),
			        BlockStateProvider.simple(BlockInit.CARROT_LEAVES.get()),
			        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 4),
			        new TwoLayersFeatureSize(1, 1, 2))
					.dirt(BlockStateProvider.simple(BlockInit.CARROT_GRASS.get()))
					.build()));;
			        
			        
			           
    public static final RegistryObject<ConfiguredFeature<?, ?>> CARROT_SPAWN = 
    		CONFIGURED_FEATURES.register("carrot_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.CARROT_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.CARROT_CHECKED.getHolder().get())));
			        
			        
    public static void register(IEventBus eventBus) {
            CONFIGURED_FEATURES.register(eventBus);
			        
    }
	
	
}