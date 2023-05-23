package com.CAIT.oinkers.integration;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.init.BlockInit;
import com.CAIT.oinkers.recipe.CarrotInfuserRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CarrotInfuserRecipeCatagory implements IRecipeCategory<CarrotInfuserRecipe>{
	
	 public final static ResourceLocation UID = new ResourceLocation(oinkers.MOD_ID, "carrot_infusing");
	    public final static ResourceLocation TEXTURE =
	            new ResourceLocation(oinkers.MOD_ID, "textures/gui/carrot_infuser_gui.png");

	    private final IDrawable background;
	    private final IDrawable icon;

	    public CarrotInfuserRecipeCatagory(IGuiHelper helper) {
	    	this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
	    	this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.CARROT_INFUSING_STATION.get()));
	    }
	    
	    
	@Override
	public RecipeType<CarrotInfuserRecipe> getRecipeType() {
		// TODO Auto-generated method stub
		return JEIoinkersModPlugin.INFUSION_TYPE;
	}

	@Override
	public Component getTitle() {
		// TODO Auto-generated method stub
		return Component.literal("Carrot Infuser");
		
	}

	@Override
	public IDrawable getBackground() {
		// TODO Auto-generated method stub
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		// TODO Auto-generated method stub
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, CarrotInfuserRecipe recipe, IFocusGroup focuses) {
		
		builder.addSlot(RecipeIngredientRole.INPUT, 56, 36).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 86, 60).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 28, 15).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 28, 60).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 137, 36).addItemStack(recipe.getResultItem());
		
	}

}
