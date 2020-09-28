package paperdomo101.aether_rewoven.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import paperdomo101.aether_rewoven.state.property.AetherProperties;

public class DoubleDropBlock extends Block {

    public static BooleanProperty DOUBLE_DROP;

    public DoubleDropBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)(this.stateManager.getDefaultState()).with(DOUBLE_DROP, true));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(DOUBLE_DROP, false);
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(DOUBLE_DROP);
    }

    static {
        DOUBLE_DROP = AetherProperties.DOUBLE_DROP;
    }
}