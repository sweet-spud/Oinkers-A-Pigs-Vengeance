package com.CAIT.oinkers.event;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.WigglerEntity;
import com.CAIT.oinkers.entity.custom.pig.GoldPigEntity;
import com.CAIT.oinkers.entity.custom.pig.IronPigEntity;
import com.CAIT.oinkers.entity.custom.pig.StonePigEntity;
import com.CAIT.oinkers.init.ModEntityTypes;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = oinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {
	
	@SubscribeEvent
	public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(ModEntityTypes.WIGGLER.get(), WigglerEntity.setAttributes());
		event.put(ModEntityTypes.STONE_PIG.get(), StonePigEntity.createAttributes());
		event.put(ModEntityTypes.IRON_PIG.get(), IronPigEntity.createAttributes());
		event.put(ModEntityTypes.GOLD_PIG.get(), GoldPigEntity.createAttributes());
	}
}
