package com.CAIT.oinkers.recipe;

import org.jetbrains.annotations.Nullable;

import com.CAIT.oinkers.oinkers;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class CarrotInfuserRecipe implements Recipe<SimpleContainer>{
	
	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public CarrotInfuserRecipe(ResourceLocation id, ItemStack stack, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.output = stack;
		this.recipeItems = recipeItems;
	}
	
	@Override
	public boolean matches(SimpleContainer container, Level level) {
		if(level.isClientSide()) {
			return false;
		}
		boolean recipeSlot1 = false;
		boolean recipeSlot2 = false;
		boolean recipeSlot3 = false;
		boolean recipeSlot4 = false;
		boolean containerSlot1 = false;
		boolean containerSlot2 = false;
		boolean containerSlot3 = false;
		boolean containerSlot4 = false;
		
		for(int i = 0; i<1; i++) {
			if(recipeSlot1 == false) {
					if(recipeItems.get(1).test(container.getItem(1)) && containerSlot1 == false) {
						recipeSlot1 = true;
						containerSlot1 = true;
						break;
					}
					if(recipeItems.get(1).test(container.getItem(2)) && containerSlot2 == false) {
						recipeSlot1 = true;
						containerSlot2 = true;
						break;
					}
					if(recipeItems.get(1).test(container.getItem(3)) && containerSlot3 == false) {
						recipeSlot1 = true;
						containerSlot3 = true;
						break;
					}
					if(recipeItems.get(1).test(container.getItem(4)) && containerSlot4 == false) {
						recipeSlot1 = true;
						containerSlot4 = true;
						break;
					}
			}
		}
		for(int i = 0; i<1; i++) {
			if(recipeSlot2 == false) {
					if(recipeItems.get(2).test(container.getItem(1)) && containerSlot1 == false) {
						recipeSlot2 = true;
						containerSlot1 = true;
						break;
					}
					if(recipeItems.get(2).test(container.getItem(2)) && containerSlot2 == false) {
						recipeSlot2 = true;
						containerSlot2 = true;
						break;
					}
					if(recipeItems.get(2).test(container.getItem(3)) && containerSlot3 == false) {
						recipeSlot2 = true;
						containerSlot3 = true;
						break;
					}
					if(recipeItems.get(2).test(container.getItem(4)) && containerSlot4 == false) {
						recipeSlot2 = true;
						containerSlot4 = true;
						break;
					}
			}
		}
		for(int i = 0; i<1; i++) {
			if(recipeSlot3 == false) {
					if(recipeItems.get(3).test(container.getItem(1)) && containerSlot1 == false) {
						recipeSlot3 = true;
						containerSlot1 = true;
						break;
					}
					if(recipeItems.get(3).test(container.getItem(2)) && containerSlot2 == false) {
						recipeSlot3 = true;
						containerSlot2 = true;
						break;
					}
					if(recipeItems.get(3).test(container.getItem(3)) && containerSlot3 == false) {
						recipeSlot3 = true;
						containerSlot3 = true;
						break;
					}
					if(recipeItems.get(3).test(container.getItem(4)) && containerSlot4 == false) {
						recipeSlot3 = true;
						containerSlot4 = true;
						break;
					}
			}
		}
		for(int i = 0; i<1; i++) {
			if(recipeSlot4 == false) {
					if(recipeItems.get(4).test(container.getItem(1)) && containerSlot1 == false) {
						recipeSlot4 = true;
						containerSlot1 = true;
						break;
					}
					if(recipeItems.get(4).test(container.getItem(2)) && containerSlot2 == false) {
						recipeSlot4 = true;
						containerSlot2 = true;
						break;
					}
					if(recipeItems.get(4).test(container.getItem(3)) && containerSlot3 == false) {
						recipeSlot4 = true;
						containerSlot3 = true;
						break;
					}
					if(recipeItems.get(4).test(container.getItem(4)) && containerSlot4 == false) {
						recipeSlot4 = true;
						containerSlot4 = true;
						break;
					}
			}
		}
		
		boolean firstSlot = recipeItems.get(0).test(container.getItem(0));
		boolean secondSlot = recipeSlot1;
		boolean thirdSlot = recipeSlot2;
		boolean fourthSlot = recipeSlot3;
		boolean fifthSlot = recipeSlot4;
		
		if(firstSlot && secondSlot && thirdSlot && fourthSlot && fifthSlot) {
			return true;
		}
		else 
			return false;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer container) {
		// TODO Auto-generated method stub
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		// TODO Auto-generated method stub
		return output.copy();
	}

	@Override
	public ResourceLocation getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return Type.INSTANCE;
	}
	
	public static class Type implements RecipeType<CarrotInfuserRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "carrot_infusing";
    }
	public static class Serializer implements RecipeSerializer<CarrotInfuserRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(oinkers.MOD_ID, "carrot_infusing");

        @Override
        public CarrotInfuserRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(5, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CarrotInfuserRecipe(pRecipeId, output, inputs);
        }

        @Override
        public @Nullable CarrotInfuserRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new CarrotInfuserRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CarrotInfuserRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}
