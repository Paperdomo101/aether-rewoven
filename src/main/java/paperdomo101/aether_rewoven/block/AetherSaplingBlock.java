package paperdomo101.aether_rewoven.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import paperdomo101.aether_rewoven.registry.AetherBlocks;

public class AetherSaplingBlock extends SaplingBlock {

    public AetherSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(AetherBlocks.AETHER_GRASS_BLOCK) || floor.isOf(AetherBlocks.AETHER_DIRT) || floor.isOf(AetherBlocks.ENCHANTED_AETHER_GRASS_BLOCK);
    }
    
}