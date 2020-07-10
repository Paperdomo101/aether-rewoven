package paperdomo101.aether_rewoven.block;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.registry.AetherDimensions;

public class UnrestrictedSoulFireBlock extends AbstractFireBlock {

    public UnrestrictedSoulFireBlock(Settings settings) {
        super(settings, 2.0F);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
    
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        
        BlockPos blockPos = pos.down();
        if (SoulFireBlock.isSoulBase(world.getBlockState(blockPos).getBlock())) {
            world.setBlockState(pos, Blocks.SOUL_FIRE.getDefaultState());
        }
        
        if (!oldState.isOf(state.getBlock())) {
           if (world.getRegistryKey() != World.OVERWORLD && world.getRegistryKey() != AetherDimensions.AETHER || !AetherPortalBlock.createPortalAt(world, pos)) {
              if (!state.canPlaceAt(world, pos)) {
                 world.removeBlock(pos, false);
              }
  
           }
        }
    }
}