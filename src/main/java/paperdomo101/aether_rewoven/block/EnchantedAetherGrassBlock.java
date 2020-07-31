package paperdomo101.aether_rewoven.block;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.registry.AetherParticles;

public class EnchantedAetherGrassBlock extends AetherGrassBlock {

    public EnchantedAetherGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5D + (0.5D - random.nextDouble());
        double e = (double)pos.getY() + 1.0D;
        double f = (double)pos.getZ() + 0.5D + (0.5D - random.nextDouble());
        double g = (double)random.nextFloat() * 0.02D;
        world.addParticle(AetherParticles.AMBROSIUM_DUST, d, e, f, 0.0D, g, 0.0D);
        
    }
}