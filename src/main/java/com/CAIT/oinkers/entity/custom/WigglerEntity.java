package com.CAIT.oinkers.entity.custom;

import com.CAIT.oinkers.init.ModEntityTypes;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WigglerEntity extends Animal implements IAnimatable{
	private AnimationFactory  factory = new AnimationFactory(this);

	public WigglerEntity(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
	}
	
	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 20)
				.add(Attributes.MOVEMENT_SPEED, .2f).build();
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob p_146744_) {
		return ModEntityTypes.WIGGLER.get().create(level);
	}
	
	@Override
	public boolean isFood(ItemStack pStack) {
		return pStack.is(Items.BONE_MEAL);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
	      this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
	      this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.BONE_MEAL), false));
	      this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
	      this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	      this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
	      this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wiggler.walk", true));
			return (PlayState.CONTINUE);
		}
		return (PlayState.CONTINUE);
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
		
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}	
	
}
