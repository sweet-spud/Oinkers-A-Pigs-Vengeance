package com.CAIT.oinkers.entity.custom.pig;

import com.CAIT.oinkers.entity.custom.WigglerEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class StonePigEntity extends Monster implements IAnimatable {
	private AnimationFactory  factory = new AnimationFactory(this);
	private Vec3 prevPosition = null;
	
	public StonePigEntity(EntityType<? extends StonePigEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		prevPosition = this.position();
	}

	public static AttributeSupplier createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 42.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, .1d).add(Attributes.ATTACK_DAMAGE, 12.0D)
	    		  .add(Attributes.ARMOR, 10D).add(Attributes.KNOCKBACK_RESISTANCE, 5f)
	    		  .add(Attributes.MAX_HEALTH, 20D).build();
	}
	
	
		
	@Override
	protected void registerGoals() {
	      this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 3d, false));
	      this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1D));
	      this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
	      this.goalSelector.addGoal(7,  new RandomLookAroundGoal(this));
	      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
	      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Player.class)).setAlertOthers());
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, WigglerEntity.class, true));
	}
	
	private boolean isWalking() {
		if ((this.level.isClientSide())) {
			if ((this.prevPosition.x() != this.position().x()) || (this.prevPosition.y() != this.position().y())
					|| (this.prevPosition.z() != this.position().z())) {
				return true;
			}
		}
		return false;
	}
	
	private <E extends IAnimatable> PlayState chargePredicate(AnimationEvent<E> event) {
		if (this.isAggressive()) {
			event.getController().setAnimation(new AnimationBuilder()
					.addAnimation("animation.stone_pig.charge_run", EDefaultLoopTypes.LOOP));
			return (PlayState.CONTINUE);
		}
		else {
			return (PlayState.STOP);
		}
	}
	private <E extends IAnimatable> PlayState walkPredicate(AnimationEvent<E> event) {
		if (isWalking()) { 
			event.getController().setAnimation(new AnimationBuilder()
					.addAnimation("animation.stone_pig.walk", EDefaultLoopTypes.LOOP));
			return (PlayState.CONTINUE);
		}
		else {
			return (PlayState.STOP);
		}
	}
	@Override
	public void tick() {
		prevPosition = this.position();
		super.tick();
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "chargeController", 0, this::chargePredicate));	
		data.addAnimationController(new AnimationController(this, "walkController", 0, this::walkPredicate));		
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	
	
}
