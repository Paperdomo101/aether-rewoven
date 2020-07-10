package paperdomo101.aether_rewoven.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.block.AetherPortalBlock;
import paperdomo101.aether_rewoven.registry.AetherDimensions;

@Mixin(SoulFireBlock.class)
public abstract class SoulFireBlockMixin extends AbstractFireBlock {
    
    public SoulFireBlockMixin(Settings settings, float damage) {
        super(settings, damage);
    }

    // @Inject(method = "onBlockAdded", at = @At("HEAD"))
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            if (world.getRegistryKey() != World.OVERWORLD && world.getRegistryKey() != AetherDimensions.AETHER || !AetherPortalBlock.createPortalAt(world, pos)) {
               if (!state.canPlaceAt(world, pos)) {
                  world.removeBlock(pos, false);
               }
            }
        }
    }
}