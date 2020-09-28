package paperdomo101.aether_rewoven.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.state.property.AetherProperties;

public class AetherGrassBlock extends AetherSpreadableBlock {

    public static final BooleanProperty SNOWY;
    public static final BooleanProperty DOUBLE_DROP;
    
    public AetherGrassBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)(BlockState)(this.stateManager.getDefaultState()).with(SNOWY, false).with(DOUBLE_DROP, true));
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(DOUBLE_DROP, false);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(SNOWY, DOUBLE_DROP);
    }

    static {
        SNOWY = Properties.SNOWY;
        DOUBLE_DROP = AetherProperties.DOUBLE_DROP;
    }
}