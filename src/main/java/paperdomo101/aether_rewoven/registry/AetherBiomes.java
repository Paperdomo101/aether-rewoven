package paperdomo101.aether_rewoven.registry;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.world.biome.AetherHighlandsBiome;
import paperdomo101.aether_rewoven.world.biome.source.AetherBiomeSource;

public class AetherBiomes {

    public static Biome AETHER_HIGHLANDS;

    public static void init() {
        Registry.register(Registry.BIOME_SOURCE, AetherRewoven.id("aether"), AetherBiomeSource.CODEC);

        AETHER_HIGHLANDS = Registry.register(Registry.BIOME, AetherRewoven.id("aether_highlands"), new AetherHighlandsBiome());
    }
}