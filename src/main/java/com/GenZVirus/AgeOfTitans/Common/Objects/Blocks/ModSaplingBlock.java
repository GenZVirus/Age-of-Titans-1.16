package com.GenZVirus.AgeOfTitans.Common.Objects.Blocks;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

public class ModSaplingBlock extends BushBlock implements IGrowable{

	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	private final Supplier<Tree> tree;
	
	public ModSaplingBlock(Supplier<Tree> treeIn, Properties properties) {
		super(properties);
		this.tree = treeIn;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if(!worldIn.isAreaLoaded(pos, 1)) {
			return;
		}
		if(worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
			this.grow(worldIn, rand, pos, state);
		}
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(ServerWorld serverWorld, Random rand, BlockPos pos, BlockState state) {
		if(state.get(STAGE) == 0) {
			serverWorld.setBlockState(pos, state.func_235896_a_(STAGE), 4);
		} else {
			if(!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos)) return;
			this.tree.get().attemptGrowTree(serverWorld, serverWorld.getChunkProvider().getChunkGenerator(), pos, state, rand);
		}
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}

}
