package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.effect.CarrotThirst;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffectsInit {

	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, oinkers.MOD_ID);
	
	public static final RegistryObject<MobEffect> CARROT_THIRST = EFFECTS.register("carrot_thirst",
			() -> new CarrotThirst(MobEffectCategory.HARMFUL, 3128730));
	
	public static void register(IEventBus bus) {
		EFFECTS.register(bus);
	}
}
