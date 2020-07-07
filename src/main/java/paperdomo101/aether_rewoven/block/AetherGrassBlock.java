package paperdomo101.aether_rewoven.block;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.registry.AetherParticles;

public class AetherGrassBlock extends AetherSpreadableBlock {

    public static final BooleanProperty DOUBLE_DROP = BooleanProperty.of(AetherRewoven.doubleDropNotifier());
    public static final BooleanProperty ENCHANTED = BooleanProperty.of("enchanted");
    public static final BooleanProperty SNOWY = Properties.SNOWY;
    
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
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if ((Boolean)state.get(ENCHANTED).booleanValue()) {
            if (random.nextInt(5) == 0) {
               world.addParticle(AetherParticles.AMBROSIUM_DUST, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(DOUBLE_DROP, ENCHANTED, SNOWY);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moved) {
        world.setBlockState(pos, state.with(DOUBLE_DROP, false));
    }
}