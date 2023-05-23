package com.CAIT.oinkers.world.dimension;

import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.util.ITeleporter;

public class ModTeleporter implements ITeleporter{

	private BlockPos pos;
	
	public ModTeleporter(BlockPos pos) {
		this.pos = pos;
	}
	
	@Override
	public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw,
			Function<Boolean, Entity> repositionEntity) {
		
		if (!(entity instanceof ServerPlayer)) {
			return entity;
		}
		
		ServerPlayer player = (ServerPlayer)entity;
		LevelChunk chunk = (LevelChunk) destWorld.getChunk(pos);
		int y = 0;
		while (!chunk.getBlockState(pos.above(y)).isAir()) {
			y++;
		}
		player.teleportTo(destWorld, pos.getX(), pos.getY()+y, pos.getZ(), 0, 0);
		return entity;
	}
}
