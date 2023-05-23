package com.CAIT.oinkers.block.custom;

import com.CAIT.oinkers.block.entity.CarrotInfusingStationBlockEntity;
import com.CAIT.oinkers.block.entity.ModBlockEntitiesTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

public class CarrotInfusingStationBlock extends BaseEntityBlock{
	
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public CarrotInfusingStationBlock(Properties properties) {
		
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 10, 16);
	
	@Override
	public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_,
			CollisionContext p_60558_) {
		// TODO Auto-generated method stub
		return SHAPE;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
	}
	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	/* BLOCK ENTITY */
	
	@Override
	public RenderShape getRenderShape(BlockState p_49232_) {
		// TODO Auto-generated method stub
		return RenderShape.MODEL;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState,boolean pIsMoving) {
		
		if(pState.getBlock() != pNewState.getBlock()) {
			BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
			if(blockEntity instanceof CarrotInfusingStationBlockEntity) {
				((CarrotInfusingStationBlockEntity) blockEntity).drops();
			}
		}		
		super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
	}
	
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer,
			InteractionHand pHand, BlockHitResult pHit) {
		if(!pLevel.isClientSide()) {
			BlockEntity entity = pLevel.getBlockEntity(pPos);
			if(entity instanceof CarrotInfusingStationBlockEntity) {
				NetworkHooks.openScreen(((ServerPlayer)pPlayer), (CarrotInfusingStationBlockEntity)entity, pPos);
			}
			else {
				throw new IllegalStateException("Our Container provider is missing");
			}
		}
		
		return InteractionResult.sidedSuccess(pLevel.isClientSide());
	}
	

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		return new CarrotInfusingStationBlockEntity(pos, state);
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> type) {
		// TODO Auto-generated method stub
		return createTickerHelper(type, ModBlockEntitiesTypes.CARROT_INFUSING_STATION.get(), CarrotInfusingStationBlockEntity::tick);
	}
}
