package paperdomo101.aether_rewoven.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import paperdomo101.aether_rewoven.state.property.AetherProperties;

public class DoubleDropPillarBlock extends PillarBlock {
    
    public static final EnumProperty<Direction.Axis> AXIS;
    public static BooleanProperty DOUBLE_DROP;

    public DoubleDropPillarBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)(this.stateManager.getDefaultState()).with(AXIS, Direction.Axis.Y).with(DOUBLE_DROP, true));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch(rotation) {
        case COUNTERCLOCKWISE_90:
        case CLOCKWISE_90:
            switch((Direction.Axis)state.get(AXIS)) {
            case X:
                return (BlockState)state.with(AXIS, Direction.Axis.Z);
            case Z:
                return (BlockState)state.with(AXIS, Direction.Axis.X);
            default:
                return state;
            }
        default:
            return state;
        }
    }
    
    public BlockState getPlacementState(ItemPlacementContext ctx) {
       return (BlockState)this.getDefaultState().with(AXIS, ctx.getSide().getAxis()).with(DOUBLE_DROP, false);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(DOUBLE_DROP, AXIS);
    }

    static {
        AXIS = Properties.AXIS;
        DOUBLE_DROP = AetherProperties.DOUBLE_DROP;
    }
}