package com.CAIT.oinkers.fluids;

import com.CAIT.oinkers.oinkers;
import com.mojang.math.Vector3f;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidTypes {
	
	public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
	public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
	public static final ResourceLocation PIG_OVERLAY_RL = new ResourceLocation(oinkers.MOD_ID, "misc/in_pig_juice");
	
	public static final DeferredRegister<FluidType> FLUID_TYPES = 
			DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, oinkers.MOD_ID);
	
	public static final RegistryObject<FluidType> PIG_JUICE_FLUID_TYPE = register("pig_juice_fluid", 
			FluidType.Properties.create()
			.lightLevel(1)
			.density(1)
			.viscosity(1)
			.canHydrate(false)
			.canExtinguish(false)
			.canSwim(true)
			.canPushEntity(false)
			.supportsBoating(false)
			.sound(SoundAction.get("drink"), SoundEvents.WITCH_DRINK)
			);

	private static RegistryObject<FluidType> register(String name, FluidType.Properties properties){
		return FLUID_TYPES.register(name, () -> new BaseFluidTypes(WATER_STILL_RL, WATER_FLOWING_RL, PIG_OVERLAY_RL,
				0xff86d2, new Vector3f(254/255f, 201/255f, 112/255f), properties));
	}

	public static void register(IEventBus bus) {
		FLUID_TYPES.register(bus);
	}

}
