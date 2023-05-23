package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.fluids.FluidTypes;
import com.google.common.base.Supplier;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidInit {
	
	
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, oinkers.MOD_ID);
	
	
	public static final RegistryObject<FlowingFluid> PIG_JUICE = register("pig_juice", 
			() -> new ForgeFlowingFluid.Source(FluidInit.PIG_JUICE_FLUID_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_PIG_JUICE = register("flowing_carrot_juice", 
			() -> new ForgeFlowingFluid.Flowing(FluidInit.PIG_JUICE_FLUID_PROPERTIES));
	
	
	public static final ForgeFlowingFluid.Properties PIG_JUICE_FLUID_PROPERTIES = 
			new ForgeFlowingFluid.Properties(FluidTypes.PIG_JUICE_FLUID_TYPE,
					PIG_JUICE, FLOWING_PIG_JUICE)
			.slopeFindDistance(3)
			.levelDecreasePerBlock(3).block(BlockInit.PIG_JUICE_BLOCK);
	
	
	private static <T extends Fluid> RegistryObject<T> register(final String name, final Supplier<T> fluid) {
		return FLUIDS.register(name, fluid);
	}
	
	public static void register(IEventBus bus) {
		FLUIDS.register(bus);
	}

}
