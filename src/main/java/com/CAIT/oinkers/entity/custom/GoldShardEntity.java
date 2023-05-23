package com.CAIT.oinkers.entity.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class GoldShardEntity extends AbstractArrow {

	public GoldShardEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
	      super(pEntityType, pLevel);
	   }
	
	public GoldShardEntity(EntityType<? extends AbstractArrow> pEntityType, double pX, double pY, double pZ,
			Level pLevel) {
		super(pEntityType, pX, pY, pZ, pLevel);
	}

	public GoldShardEntity(EntityType<? extends AbstractArrow> pEntityType, LivingEntity pShooter, Level pLevel) {
	      super(pEntityType, pShooter, pLevel);
	   }
	
	
	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}
	
	@Override
	protected void onHitEntity(EntityHitResult pResult) {
		this.setBaseDamage(1.1);
		super.onHitEntity(pResult);
		((LivingEntity) pResult.getEntity()).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 1));
	}
	@Override
	protected void onHitBlock(BlockHitResult pResult) {
		super.onHitBlock(pResult);
//		this.level.explode(this, this.getX(), this.getY(), this.getZ(), 10, true, Explosion.BlockInteraction.DESTROY);
	}
	
	
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
