package com.CAIT.oinkers.integration;



import java.util.List;
import java.util.Objects;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.recipe.CarrotInfuserRecipe;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;


@JeiPlugin
public class JEIoinkersModPlugin implements IModPlugin{
	public static RecipeType<CarrotInfuserRecipe> INFUSION_TYPE = new RecipeType<>(CarrotInfuserRecipeCatagory.UID, CarrotInfuserRecipe.class);
	
	@Override
	public ResourceLocation getPluginUid() {
		// TODO Auto-generated method stub
		return new ResourceLocation(oinkers.MOD_ID, "jei_plugin");
	}

	@Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
        		CarrotInfuserRecipeCatagory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        @SuppressWarnings("resource")
		RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<CarrotInfuserRecipe> recipesInfusing = rm.getAllRecipesFor(CarrotInfuserRecipe.Type.INSTANCE);
        registration.addRecipes(INFUSION_TYPE, recipesInfusing);
    }
}
