package com.CAIT.oinkers.item;

import com.CAIT.oinkers.world.dimension.ModDimensions;
import com.CAIT.oinkers.world.dimension.ModTeleporter;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PigMedallion extends Item {

	public PigMedallion(Properties p_41383_) {
		super(p_41383_);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41432_, Player player, InteractionHand p_41434_) {
		if (player instanceof ServerPlayer) {
			transferPlayer((ServerPlayer)player, player.blockPosition());
		}
		return super.use(p_41432_, player, p_41434_);
	}
	
	public void transferPlayer(ServerPlayer player, BlockPos pos) {
        if (player.getVehicle() != null || player.isVehicle()) {
            return;
        }
        
        if (player.level.dimension().equals(ModDimensions.DIM_KEY)) {
        	ServerLevel teleWorld = player.server.getLevel(Level.OVERWORLD);
        	if (teleWorld == null) {
        		return;
        	}
        	player.changeDimension(teleWorld, new ModTeleporter(pos));
        }
        else if (player.level.dimension().equals(Level.OVERWORLD)) {
        	ServerLevel teleWorld = player.server.getLevel(ModDimensions.DIM_KEY);
        	if (teleWorld == null) {
        		return;
        	}
        	player.changeDimension(teleWorld, new ModTeleporter(pos));
        }
	}
}
