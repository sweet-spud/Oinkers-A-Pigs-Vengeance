package com.CAIT.oinkers.screen;

import com.CAIT.oinkers.oinkers;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
	
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = 
			DeferredRegister.create(ForgeRegistries.MENU_TYPES, oinkers.MOD_ID);
	
	public static final RegistryObject<MenuType<CarrotInfuserMenu>> CARROT_INFUSER_MENU = registerMenuType(CarrotInfuserMenu::new, "carrot_infuser_menu");
		
	
	private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> 
																											factory, String name){
		return MENU_TYPES.register(name, () -> IForgeMenuType.create(factory));
	}
	
	
	public static void register(IEventBus bus) {
		MENU_TYPES.register(bus);
	}

}
