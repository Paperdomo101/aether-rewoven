package paperdomo101.aether_rewoven.world.gen.surfacebuilder;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import paperdomo101.aether_rewoven.registry.AetherBlocks;

public class AetherSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {

    public static final BlockState AIR = Blocks.AIR.getDefaultState();
    public static final BlockState AETHER_DIRT = AetherBlocks.AETHER_DIRT.getDefaultState();;
    public static final BlockState AETHER_GRASS_BLOCK = AetherBlocks.AETHER_GRASS_BLOCK.getDefaultState();
    public static final TernarySurfaceConfig AETHER_GRASS_CONFIG = new TernarySurfaceConfig(AETHER_GRASS_BLOCK, AETHER_DIRT, AETHER_DIRT);
    public static final SurfaceBuilder<TernarySurfaceConfig> AETHER = register("aether", new DefaultSurfaceBuilder(TernarySurfaceConfig.CODEC));;

    private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> F register(String string, F surfaceBuilder) {
        return (F) Registry.register(Registry.SURFACE_BUILDER, (String) string, surfaceBuilder);
    }

    public AetherSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig surfaceBlocks) {

    }
    
}