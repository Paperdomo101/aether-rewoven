package paperdomo101.aether_rewoven.registry;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.world.gen.chunk.AetherChunkGenerator;

public class AetherDimensions {
    public static final RegistryKey<DimensionType> THE_AETHER = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, AetherRewoven.id("the_aether"));
    public static final RegistryKey<World> AETHER = RegistryKey.of(Registry.DIMENSION, AetherRewoven.id("the_aether"));

    public static void init() {
		Registry.register(Registry.CHUNK_GENERATOR, AetherRewoven.id("the_aether"), AetherChunkGenerator.CODEC);

    }
}