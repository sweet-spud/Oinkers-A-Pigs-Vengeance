package com.CAIT.oinkers.world.feature;

import java.util.List;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.init.BlockInit;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
	
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = 
			DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, oinkers.MOD_ID);
	
	
	public static final RegistryObject<PlacedFeature> CARROT_ORE_PLACED = PLACED_FEATURES.register("carrot_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CARROT_ORE.getHolder().get(),
                    commonOrePlacement(3, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(70)))));
	
	
	
	 public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
	        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	    }

	    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
	        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	    }

	    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
	        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
	    }
	
	
	
	public static final RegistryObject<PlacedFeature> CARROT_CHECKED = PLACED_FEATURES.register("carrot_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.CARROT.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(BlockInit.CARROT_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> CARROT_PLACED = PLACED_FEATURES.register("carrot_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CARROT_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(6, 0.1f, 4))));
	
    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
		        
}
}
