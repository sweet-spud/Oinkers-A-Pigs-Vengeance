package com.CAIT.oinkers.entity.custom.pig;

import java.util.EnumSet;

import com.CAIT.oinkers.entity.custom.GoldShardEntity;
import com.CAIT.oinkers.entity.custom.WigglerEntity;
import com.CAIT.oinkers.init.ModEntityTypes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
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

public class GoldPigEntity extends Monster implements IAnimatable {

	private AnimationFactory  factory = new AnimationFactory(this);
	private Vec3 prevPosition = null;
	
	public GoldPigEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		prevPosition = this.position();
	}

	public static AttributeSupplier createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 50.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, .25d)
	    		  .add(Attributes.ARMOR, 15D).add(Attributes.MAX_HEALTH, 30D).add(Attributes.ATTACK_DAMAGE, 16d).build();
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(4, new GoldPigEntity.GoldPigAttackGoal(this));
	      this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1D));
	      this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
	      this.goalSelector.addGoal(7,  new RandomLookAroundGoal(this));
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
	
	@Override
	public void tick() {
		prevPosition = this.position();
		super.tick();
	}
	
	private <E extends IAnimatable> PlayState walkPredicate(AnimationEvent<E> event) {
		if (isWalking()) { 
			event.getController().setAnimation(new AnimationBuilder()
					.addAnimation("animation.gold_pig.walk", EDefaultLoopTypes.LOOP));
			return (PlayState.CONTINUE);
		}
		else {
			return (PlayState.STOP);
		}
	}
	
	private <E extends IAnimatable> PlayState attackPredicate(AnimationEvent<E> event) {
		if (this.isAggressive()) {
			event.getController().setAnimation(new AnimationBuilder()
					.addRepeatingAnimation("animation.gold_pig.angry_thing", 2)
					.addAnimation("animation.gold_pig.charge", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		else {
			return PlayState.STOP;
		}
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "walkController", 0, this::walkPredicate));		
		data.addAnimationController(new AnimationController(this, "attackController", 0, this::attackPredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	
	
	static class GoldPigAttackGoal extends Goal {
		private final GoldPigEntity pGoldPig;
	      private int attackStep;
	      private int attackTime;
	      private int lastSeen;

	      public GoldPigAttackGoal(GoldPigEntity pGoldPig) {
	         this.pGoldPig = pGoldPig;
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean canUse() {
	         LivingEntity livingentity = this.pGoldPig.getTarget();
	         return livingentity != null && livingentity.isAlive() && this.pGoldPig.canAttack(livingentity);
	      }

	      /**
	       * Execute a one shot task or start executing a continuous task
	       */
	      public void start() {
	         this.attackStep = 0;
	         this.pGoldPig.setAggressive(true);
	      }

	      /**
	       * Reset the task's internal state. Called when this task is interrupted by another one
	       */
	      public void stop() {
	         this.lastSeen = 0;
	         this.pGoldPig.setAggressive(false);
	      }

	      public boolean requiresUpdateEveryTick() {
	         return true;
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         --this.attackTime;
	         LivingEntity livingentity = this.pGoldPig.getTarget();
	         if (livingentity != null) {
	            boolean flag = this.pGoldPig.getSensing().hasLineOfSight(livingentity);
	            if (flag) {
	               this.lastSeen = 0;
	            } else {
	               ++this.lastSeen;
	            }

	            double d0 = this.pGoldPig.distanceToSqr(livingentity);
	            if (d0 < 6 && flag) {
	               if (this.attackTime <= 0) {
	                  this.attackTime = 20;
	                  this.pGoldPig.doHurtTarget(livingentity);
		              this.pGoldPig.getNavigation().moveTo(livingentity, 1);
		              this.pGoldPig.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
	               }

	            } else if (d0 < this.getFollowDistance() * this.getFollowDistance() * 0.4 && flag) {
	               double d1 = livingentity.getX() - this.pGoldPig.getX();
	               double d2 = livingentity.getY(0.5D) - this.pGoldPig.getY(0.5D);
	               double d3 = livingentity.getZ() - this.pGoldPig.getZ();
	               if (this.attackTime <= 0) {
	                  ++this.attackStep; 
	                  if (this.attackStep == 1) {
	                     this.attackTime = 10;
	                  } else if (this.attackStep <= 4) {
	                     this.attackTime = 6;
	                  } else {
	                     this.attackTime = 15;
	                     this.attackStep = 0;
	                  }

	                  if (this.attackStep > 1) {
	  //                   double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
	                     for(int i = 0; i < 1; ++i) {
	                     //   SmallFireball smallfireball = new SmallFireball(this.pIronPig.level, this.pIronPig, this.pIronPig.getRandom().triangle(d1, 2.297D * d4), d2, this.pIronPig.getRandom().triangle(d3, 2.297D * d4));
	                     //   smallfireball.setPos(smallfireball.getX(), this.pIronPig.getY(0.5D) + 0.5D, smallfireball.getZ());
	                    	GoldShardEntity shard = new GoldShardEntity(ModEntityTypes.GOLD_SHARD.get(), this.pGoldPig, this.pGoldPig.level);
		                    shard.setPos(this.pGoldPig.getX(), this.pGoldPig.getY(0.7D) + 0.5D, this.pGoldPig.getZ());
		                    double factor = 0;
		                    if (abs(d1) > abs(d2) && abs(d1) > abs(d3)) {
		                    	factor = 1 / abs(d1);
		                    }
		                    else if (abs(d2) > abs(d1) && abs(d2) > abs(d3)) {
		                    	factor = 1/ abs(d2);
		                    }
		                    else if (abs(d3) > abs(d1) && abs(d3) > abs(d2)) {
		                    	factor = 1/ abs(d3);
		                    }
		                    d1 = d1 * factor; d2 = d2 * factor; d3 = d3 * factor;
		                    
		                    shard.setDeltaMovement(d1*5, d2*5, d3*5);
	   //                     this.pGoldPig.playSound(SoundEvents.IRON_GOLEM_DAMAGE);
	                        this.pGoldPig.level.addFreshEntity(shard);
	                     }
	                  }
	               }
	               this.pGoldPig.getNavigation().moveTo(livingentity, 1);
	               this.pGoldPig.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
	            } 
	            else if (flag) {
		               this.pGoldPig.getNavigation().moveTo(livingentity, 1);
	            }
	            else if (this.lastSeen < 5) {
		               this.pGoldPig.getNavigation().moveTo(livingentity, 1);
	            }

	            super.tick();
	         }
	      }

	      private double getFollowDistance() {
	         return this.pGoldPig.getAttributeValue(Attributes.FOLLOW_RANGE);
	      }
	}
	
	private static double abs(double n) {
		if (n<0) {
			return -n;
		}
		return n;
	}
}
