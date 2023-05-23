package com.CAIT.oinkers.world.feature.tree;

import com.CAIT.oinkers.world.feature.ModConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CarrotTreeGrower extends AbstractTreeGrower{

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source,
			boolean check) {
		return ModConfiguredFeatures.CARROT.getHolder().get();
	}

}
