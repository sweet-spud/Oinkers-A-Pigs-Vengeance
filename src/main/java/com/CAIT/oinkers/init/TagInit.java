package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TagInit {
	
	public static void setup()
    {
		
        Blocks.setup();
        Fluids.setup();
    }

    public static class Blocks {
        private static void setup() {
        	}
        	
        	public static final TagKey<Block> carrot_wood = tag("carrot_wood");
        	
        	public static final TagKey<Block> ANIMALS_SPAWNABLE_ON = tag("animals_spawnable_on");
	    	public static final TagKey<Block> MONSTERS_SPAWNABLE_ON = tag("monsters_spawnable_on");
        	
        	public static final TagKey<Block> planks = minecrafttag("planks");
        	
        	
        	private static TagKey<Block> tag(String name){
        		TagKey<Block> tag = BlockTags.create(new ResourceLocation(oinkers.MOD_ID, name));
        		return tag;
        	}
        	private static TagKey<Block> forgetag(String name){
        		TagKey<Block> tag = BlockTags.create(new ResourceLocation("forge", name));
        		return tag;
        	}
        	private static TagKey<Block> minecrafttag(String name){
        		TagKey<Block> tag = BlockTags.create(new ResourceLocation("minecraft", name));
        		return tag;
        	}
        	
        
    }
    
    public static class Items{
    	private static void setup() {}
    	
    	private static TagKey<Item> tag(String name){
    		TagKey<Item> tag = ItemTags.create(new ResourceLocation(oinkers.MOD_ID, name));
    		return tag;
    	}
    	private static TagKey<Item> forgetag(String name){
    		TagKey<Item> tag = ItemTags.create(new ResourceLocation("forge", name));
    		return tag;
    	}
    	private static TagKey<Item> minecrafttag(String name){
    		TagKey<Item> tag = ItemTags.create(new ResourceLocation("minecraft", name));
    		return tag;
    	}
    	
    }
    public static class Fluids {
        private static void setup() {}
        
    }
	
	
	

}
