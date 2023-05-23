package com.CAIT.oinkers.init;

import com.CAIT.oinkers.entity.custom.pig.StonePigEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent
	public void breakItem(PlayerDestroyItemEvent event) {	// When item broke
		Player player = event.getEntity();
		if (event.getOriginal().getItem().equals(ItemInit.CARROT_SHANK.get())) {	// If Carrot Shank give player stick
			player.addItem(new ItemStack(Items.STICK));
		}
	}
	@SubscribeEvent
	public void entityHurt(LivingHurtEvent event) {	// Entity hurt (before damage calculations)
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if ((player.getInventory().getArmor(0).getItem() == ItemInit.LEVITATING_BOOTS.get()) && (event.getSource().isFall())) {
				// If levitating boots and taking fall damage
				event.setCanceled(true);	// Cancel damage
				player.getInventory().getArmor(0).hurtAndBreak(1, player, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.FEET));
			}
		}
		if (event.getSource().getEntity() instanceof StonePigEntity) {
			event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1));
		}
	}
	
	@SubscribeEvent
	public void anvilUpdate(AnvilUpdateEvent event) {	// Any change made in anvil
		if (event.getLeft().getItem() == ItemInit.CARROT_ROD_OF_FIRE_1.get() && event.getRight().getItem() == ItemInit.CARROT_ROD_OF_FIRE_1.get()) {
			event.setCost(20);
			event.setOutput(new ItemStack(ItemInit.CARROT_ROD_OF_FIRE_2.get(), 1));
		}
		else if (event.getLeft().getItem() == ItemInit.CARROT_ROD_OF_FIRE_2.get() && event.getRight().getItem() == ItemInit.CARROT_ROD_OF_FIRE_2.get()) {
			event.setCost(30);
			event.setOutput(new ItemStack(ItemInit.CARROT_ROD_OF_FIRE_3.get(), 1));
		}
		else if (event.getLeft().getItem() == ItemInit.CARROT_ROD_OF_LIGHT_1.get() && event.getRight().getItem() == ItemInit.CARROT_ROD_OF_LIGHT_1.get()) {
			event.setCost(20);
			event.setOutput(new ItemStack(ItemInit.CARROT_ROD_OF_LIGHT_2.get(), 1));
		}
		else if (event.getLeft().getItem() == ItemInit.CARROT_ROD_OF_LIGHT_2.get() && event.getRight().getItem() == ItemInit.CARROT_ROD_OF_LIGHT_2.get()) {
			event.setCost(30);
			event.setOutput(new ItemStack(ItemInit.CARROT_ROD_OF_LIGHT_3.get(), 1));
		}
		else if (event.getLeft().getItem() == ItemInit.CARROT_ROD_OF_SPRING_1.get() && event.getRight().getItem() == ItemInit.CARROT_ROD_OF_SPRING_1.get()) {
			event.setCost(20);
			event.setOutput(new ItemStack(ItemInit.CARROT_ROD_OF_SPRING_2.get(), 1));
		}
		else if (event.getLeft().getItem() == ItemInit.CARROT_ROD_OF_SPRING_2.get() && event.getRight().getItem() == ItemInit.CARROT_ROD_OF_SPRING_2.get()) {
			event.setCost(30);
			event.setOutput(new ItemStack(ItemInit.CARROT_ROD_OF_SPRING_3.get(), 1));
		}
	}
}
