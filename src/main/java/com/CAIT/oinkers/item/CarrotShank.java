package com.CAIT.oinkers.item;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.advancements.critereon.PlayerPredicate.Builder;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.Lazy;

public class CarrotShank extends SwordItem{

	

	public CarrotShank(Tier tier, int damageModifier, float attackSpeed, Properties properties) {
		super(tier, damageModifier, attackSpeed, properties);
	}
	
	@Override
	public boolean isEnchantable(ItemStack p_41456_) {
		return false;
	}
	
    public final Lazy<Multimap<Attribute, AttributeModifier>> LAZY = Lazy.of(() ->  {    
    	ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder(); 
         if (ForgeMod.REACH_DISTANCE.isPresent()) {
             builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier("Weapon modifier", -5, AttributeModifier.Operation.ADDITION));
         }
    	Multimap<Attribute, AttributeModifier> attributeModifiers = ArrayListMultimap.create();
    	attributeModifiers = builder.build();
    	return attributeModifiers;
    });

	@Override
	public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
		components.add(Component.literal("Agriculture has never been so deadly!"));
		super.appendHoverText(p_41421_, p_41422_, components, p_41424_);
	}
	
	
}
