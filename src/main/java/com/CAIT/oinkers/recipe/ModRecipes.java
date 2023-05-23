package com.CAIT.oinkers.recipe;

import com.CAIT.oinkers.oinkers;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = 
			DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, oinkers.MOD_ID);
	
	public static final RegistryObject<RecipeSerializer<CarrotInfuserRecipe>> CARROT_INFUSING_SERIALIZER =
			SERIALIZERS.register("carrot_infusing", () -> CarrotInfuserRecipe.Serializer.INSTANCE);
	

	
	public static void register(IEventBus bus) {
		SERIALIZERS.register(bus);
	}
	
}
