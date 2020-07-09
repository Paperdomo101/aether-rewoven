package paperdomo101.aether_rewoven.world.biome;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import paperdomo101.aether_rewoven.world.gen.surfacebuilder.AetherSurfaceBuilder;

public class AetherHighlandsBiome extends AetherBiome {

	public AetherHighlandsBiome() {
		super(new Biome.Settings().configureSurfaceBuilder(AetherSurfaceBuilder.AETHER, AetherSurfaceBuilder.AETHER_GRASS_CONFIG)
				.precipitation(Biome.Precipitation.NONE)
				.category(Biome.Category.BEACH)
				.depth(0.1F)
				.scale(0.2F)
				.temperature(0.5F)
				.downfall(0.5F)
				.effects(new BiomeEffects.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build())
				.parent(null));
	}
}