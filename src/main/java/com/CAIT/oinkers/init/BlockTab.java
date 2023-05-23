package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BlockTab {
	
public static final CreativeModeTab BlockTab = new CreativeModeTab(oinkers.MOD_ID + "_blocks") {
		
		@Override
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return (new ItemStack(BlockInit.CARROT_GRASS.get().asItem()));
		}
	};

}
