package paperdomo101.aether_rewoven.block;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;

public class UnrestrictedSoulFireBlock extends AbstractFireBlock {

    public UnrestrictedSoulFireBlock(Settings settings) {
        super(settings, 2.0F);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }

    /*
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
           if (world.getRegistryKey() != World.OVERWORLD && world.getRegistryKey() != AetherDimensionTypes.AETHER || !AetherPortalBlock.createPortalAt(world, pos)) {
              if (!state.canPlaceAt(world, pos)) {
                 world.removeBlock(pos, false);
              }
  
           }
        }
     }*/
}