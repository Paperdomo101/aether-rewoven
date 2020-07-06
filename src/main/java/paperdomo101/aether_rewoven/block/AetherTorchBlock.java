package paperdomo101.aether_rewoven.block;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AetherTorchBlock extends TorchBlock {

    private boolean smoke;

    public AetherTorchBlock(Settings settings, ParticleEffect particle, Boolean smoke) {
        super(settings, particle);
        this.smoke = smoke;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.7D;
        double f = (double)pos.getZ() + 0.5D;
        if (smoke) {world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);}
        world.addParticle(this.particle, d, e, f, 0.0D, 0.0D, 0.0D);
    }
}