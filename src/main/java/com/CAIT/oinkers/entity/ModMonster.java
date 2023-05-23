package com.CAIT.oinkers.entity;

import com.CAIT.oinkers.init.TagInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;


public class ModMonster {
 
   public static boolean checkMonsterSpawnRules(EntityType<? extends Monster> p_218105_, LevelAccessor level, MobSpawnType Mob, BlockPos Pos, RandomSource p_218109_) {
	      return level.getBlockState(Pos.below()).is(TagInit.Blocks.MONSTERS_SPAWNABLE_ON);
   }
}
