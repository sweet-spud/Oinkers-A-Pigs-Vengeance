package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ItemTab {

public static final CreativeModeTab ItemTab = new CreativeModeTab(oinkers.MOD_ID +"_items") {
		
		@Override
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return (new ItemStack(ItemInit.CARROT_SHANK.get()));
		}
	};
	
	
	
}
