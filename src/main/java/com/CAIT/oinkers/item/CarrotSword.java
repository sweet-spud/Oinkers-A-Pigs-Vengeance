package com.CAIT.oinkers.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class CarrotSword extends SwordItem {

	public CarrotSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
		if (super.hurtEnemy(itemStack, target, attacker)) {
			return true;
		}
		HitResult block = ((Player)attacker).pick(20D, 0F, false);
		HitResult fluid = ((Player)attacker).pick(20D, 0F, true);
		if (block.getType() == HitResult.Type.BLOCK) {
			BlockPos pos = ((BlockHitResult)block).getBlockPos();
			BlockState state = ((Player)attacker).level.getBlockState(pos);
			System.out.println(state.getBlock());
		}
		else if (fluid.getType() == HitResult.Type.BLOCK) {
			BlockPos pos = ((BlockHitResult)fluid).getBlockPos();
			BlockState state = ((Player)attacker).level.getBlockState(pos);
			System.out.println(state.getBlock());
			//
		}	

		return false;
	}
	
}