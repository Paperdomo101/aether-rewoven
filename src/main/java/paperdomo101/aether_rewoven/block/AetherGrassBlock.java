package paperdomo101.aether_rewoven.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.registry.AetherBlocks;

public class AetherGrassBlock extends SpreadableBlock {

    public static final BooleanProperty DOUBLE_DROP = BooleanProperty.of(AetherRewoven.doubleDropNotifier());
    public static final BooleanProperty ENCHANTED = BooleanProperty.of("enchanted");
    public static final BooleanProperty SNOWY = Properties.SNOWY;
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(DOUBLE_DROP, ENCHANTED, SNOWY);
    }

    public AetherGrassBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(SNOWY, false).with(ENCHANTED, false));
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public static int getMetaFromState(BlockState state) {
		int meta = 0;
		
		if (!((Boolean)state.get(DOUBLE_DROP)).booleanValue()) {
			meta |= 1;
		}
		return meta;
    }

    public BlockState getStateFromMeta(int meta) {
        return this.getDefaultState().with(DOUBLE_DROP, Boolean.valueOf(meta == 0));
     }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moved) {
        world.setBlockState(pos, state.with(DOUBLE_DROP, false));
    }

    private static boolean canSurvive(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = worldView.getBlockState(blockPos);
        if (blockState.getBlock() == Blocks.SNOW && (Integer)blockState.get(SnowBlock.LAYERS) == 1) {
           return true;
        } else {
           int i = ChunkLightProvider.getRealisticOpacity(worldView, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(worldView, blockPos));
           return i < worldView.getMaxLightLevel();
        }
    }

    private static boolean canSpread(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return canSurvive(state, worldView, pos) && !worldView.getFluidState(blockPos).isIn(FluidTags.WATER);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
           world.setBlockState(pos, AetherBlocks.AETHER_DIRT.getDefaultState());
        } else {
           if (world.getLightLevel(pos.up()) >= 9) {
              BlockState blockState = this.getDefaultState();
  
              for(int i = 0; i < 4; ++i) {
                 BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                 if (world.getBlockState(blockPos).getBlock() == AetherBlocks.AETHER_DIRT && canSpread(blockState, world, blockPos)) {
                    world.setBlockState(blockPos, (BlockState)blockState.with(SNOWY, world.getBlockState(blockPos.up()).getBlock() == Blocks.SNOW));
                 }
              }
           }
  
        }
    }
}