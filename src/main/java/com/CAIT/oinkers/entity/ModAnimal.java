package com.CAIT.oinkers.entity;

import com.CAIT.oinkers.init.TagInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ModAnimal extends Animal{

	protected ModAnimal(EntityType<? extends Animal> type, Level level) {
		super(type, level);
		// TODO Auto-generated constructor stub
	}
	
	public static boolean checkAnimalSpawnRules(EntityType<? extends Animal> p_218105_, LevelAccessor level, MobSpawnType Mob, BlockPos Pos, RandomSource p_218109_) {
	      return level.getBlockState(Pos.below()).is(TagInit.Blocks.ANIMALS_SPAWNABLE_ON) && isBrightEnoughToSpawn(level, Pos);
	   }
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		// TODO Auto-generated method stub
		return null;
	}

}
