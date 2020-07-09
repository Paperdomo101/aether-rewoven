package paperdomo101.aether_rewoven.registry;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.world.biome.AetherHighlandsBiome;

public class AetherBiomes {

    public static final Biome AETHER_HIGHLANDS = register("aether_highlands", new AetherHighlandsBiome());

    public static void init() {

    }

    protected static Biome register(String name, Biome biome) {
        return Registry.register(Registry.BIOME, AetherRewoven.id(name), biome);
    }
}