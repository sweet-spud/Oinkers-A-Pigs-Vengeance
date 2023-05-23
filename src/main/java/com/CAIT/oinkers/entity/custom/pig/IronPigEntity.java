package com.CAIT.oinkers.entity.custom.pig;

import java.util.EnumSet;

import com.CAIT.oinkers.entity.custom.IronShardEntity;
import com.CAIT.oinkers.entity.custom.WigglerEntity;
import com.CAIT.oinkers.init.ModEntityTypes;

import net.minecraft.sounds.SoundEvents;
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

public class IronPigEntity extends Monster implements IAnimatable {

	private AnimationFactory  factory = new AnimationFactory(this);
	private Vec3 prevPosition = null;
	
	public IronPigEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		prevPosition = this.position();
	}

	public static AttributeSupplier createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 42.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, .25d)
	    		  .add(Attributes.ARMOR, 5D).add(Attributes.MAX_HEALTH, 15D).add(Attributes.ATTACK_DAMAGE, 3d).build();
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(4, new IronPigEntity.IronPigAttackGoal(this));
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
					.addAnimation("animation.iron_pig.walk", EDefaultLoopTypes.LOOP));
			return (PlayState.CONTINUE);
		}
		else {
			return (PlayState.STOP);
		}
	}
	
	private <E extends IAnimatable> PlayState attackPredicate(AnimationEvent<E> event) {
		if (this.isAggressive()) {
			event.getController().setAnimation(new AnimationBuilder()
					.addRepeatingAnimation("animation.iron_pig.angry_thing", 2)
					.addAnimation("animation.iron_pig.charge", EDefaultLoopTypes.LOOP));
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

	
	
	static class IronPigAttackGoal extends Goal {
		private final IronPigEntity pIronPig;
	      private int attackStep;
	      private int attackTime;
	      private int lastSeen;

	      public IronPigAttackGoal(IronPigEntity pIronPig) {
	         this.pIronPig = pIronPig;
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean canUse() {
	         LivingEntity livingentity = this.pIronPig.getTarget();
	         return livingentity != null && livingentity.isAlive() && this.pIronPig.canAttack(livingentity);
	      }

	      /**
	       * Execute a one shot task or start executing a continuous task
	       */
	      public void start() {
	         this.attackStep = 0;
	         this.pIronPig.setAggressive(true);
	      }

	      /**
	       * Reset the task's internal state. Called when this task is interrupted by another one
	       */
	      public void stop() {
	         this.lastSeen = 0;
	         this.pIronPig.setAggressive(false);
	      }

	      public boolean requiresUpdateEveryTick() {
	         return true;
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         --this.attackTime;
	         LivingEntity livingentity = this.pIronPig.getTarget();
	         if (livingentity != null) {
	            boolean flag = this.pIronPig.getSensing().hasLineOfSight(livingentity);
	            if (flag) {
	               this.lastSeen = 0;
	            } else {
	               ++this.lastSeen;
	            }

	            double d0 = this.pIronPig.distanceToSqr(livingentity);
	            if (d0 < this.getFollowDistance()*this.getFollowDistance() * 0.7 && flag) {
	               double d1 = livingentity.getX() - this.pIronPig.getX();
	               double d2 = livingentity.getY(0.5D) - this.pIronPig.getY(0.5D);
	               double d3 = livingentity.getZ() - this.pIronPig.getZ();
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
	               //      double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
	                  
	                     for(int i = 0; i < 1; ++i) {
	                     //   SmallFireball smallfireball = new SmallFireball(this.pIronPig.level, this.pIronPig, this.pIronPig.getRandom().triangle(d1, 2.297D * d4), d2, this.pIronPig.getRandom().triangle(d3, 2.297D * d4));
	                     //   smallfireball.setPos(smallfireball.getX(), this.pIronPig.getY(0.5D) + 0.5D, smallfireball.getZ());
	                    	IronShardEntity shard = new IronShardEntity(ModEntityTypes.IRON_SHARD.get(), this.pIronPig, this.pIronPig.level);
		                    shard.setPos(this.pIronPig.getX(), this.pIronPig.getY(0.7D) + 0.5D, this.pIronPig.getZ());
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
		                    
		                    shard.setDeltaMovement(d1*6, d2*6, d3*6);
	                        this.pIronPig.playSound(SoundEvents.IRON_GOLEM_DEATH);
	                        this.pIronPig.level.addFreshEntity(shard);
	                     }
	                  }
	               }
	               if (d0 < this.getFollowDistance() * this.getFollowDistance() * 0.238) {
	            	   this.pIronPig.getNavigation().moveTo(livingentity, 1);
		               this.pIronPig.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
	               }
	            } 
	            else if (d0 < this.getFollowDistance() * this.getFollowDistance()) {
		               this.pIronPig.getNavigation().moveTo(livingentity, 1);
		               this.pIronPig.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
	            }
	            else if (this.lastSeen < 5) {
	               this.pIronPig.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
	            }

	            super.tick();
	         }
	      }

	      private double getFollowDistance() {
	         return this.pIronPig.getAttributeValue(Attributes.FOLLOW_RANGE);
	      }
	}
	
	private static double abs(double n) {
		if (n<0) {
			return -n;
		}
		return n;
	}
}
