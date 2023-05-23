package com.CAIT.oinkers.item;

import com.CAIT.oinkers.init.EnchantmentsInit;
import com.CAIT.oinkers.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CarrotRod extends Item	 {

	public CarrotRod(Properties p_43272_) {
		super(p_43272_);
	}
	
	@Override
	public boolean isFoil(ItemStack pStack) {
		return true;
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if (!(level.isClientSide())) {
			ServerLevel world = ((ServerLevel) ((LivingEntity)player).level);
			HitResult block = player.pick(20D, 0F, false);
			HitResult fluid = player.pick(20D, 0F, true);
			BlockPos pos = null;
			if (block.getType() == HitResult.Type.BLOCK) {
				pos = ((BlockHitResult)block).getBlockPos();
			}
			else if (fluid.getType() == HitResult.Type.BLOCK) {
				pos = ((BlockHitResult)fluid).getBlockPos();
			}
			else if (block.getType() == HitResult.Type.ENTITY) {
				Vec3 vec = ((EntityHitResult)block).getLocation();
				pos = new BlockPos(vec.x(), vec.y(), vec.z());
			}
			if (player.getMainHandItem().getItem() == ItemInit.CARROT_ROD_OF_LIGHT_1.get()) {
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				// 3 sec
				player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 60);
			}
			else if (player.getMainHandItem().getItem() == ItemInit.CARROT_ROD_OF_LIGHT_2.get()) {
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				// 2 sec
				player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 40);
			}
			else if (player.getMainHandItem().getItem() == ItemInit.CARROT_ROD_OF_LIGHT_3.get()) {
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
				// 1 sec
				player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 20);
			}
			else if (player.getMainHandItem().getItem() == ItemInit.CARROT_ROD_OF_FIRE_1.get()) {
                  Vec3 vec3 = player.getViewVector(1.0F);
                  double d2 = pos.getX() - (player.getX() + vec3.x * 4.0D);
                  double d3 = pos.getY() - (0.5D + player.getY());
                  double d4 = pos.getZ() - (player.getZ() + vec3.z * 4.0D);
                  LargeFireball largefireball = new LargeFireball(level, player, d2, d3, d4, 1);
                  largefireball.setPos(player.getX() + vec3.x * 4.0D, player.getY() + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                  level.addFreshEntity(largefireball);
                  // 3 sec
                  player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 60);
			}
			else if (player.getMainHandItem().getItem() == ItemInit.CARROT_ROD_OF_FIRE_2.get()) {
				Vec3 vec3 = player.getViewVector(1.0F);
	            double d2 = pos.getX() - (player.getX() + vec3.x * 4.0D);
	            double d3 = pos.getY() - (0.5D + player.getY());
	            double d4 = pos.getZ() - (player.getZ() + vec3.z * 4.0D);
	            LargeFireball largefireball = new LargeFireball(level, player, d2, d3, d4, 2);
	            largefireball.setPos(player.getX() + vec3.x * 4.0D, player.getY() + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
	            level.addFreshEntity(largefireball);
	            // 2 sec
	            player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 40);
			}
			else {
				Vec3 vec3 = player.getViewVector(1.0F);
	            double d2 = pos.getX() - (player.getX() + vec3.x * 4.0D);
	            double d3 = pos.getY() - (0.5D + player.getY());
	            double d4 = pos.getZ() - (player.getZ() + vec3.z * 4.0D);
	            LargeFireball largefireball = new LargeFireball(level, player, d2, d3, d4, 3);
	            largefireball.setPos(player.getX() + vec3.x * 4.0D, player.getY() + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
	            level.addFreshEntity(largefireball);
	            level.addFreshEntity(largefireball);
	            // 1 sec
	            player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 20);
			}				
			player.getMainHandItem().hurtAndBreak(1, player, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.MAINHAND));
		}
		return super.use(level, player, hand);
	}

}