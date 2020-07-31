package paperdomo101.aether_rewoven.world.biome;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import paperdomo101.aether_rewoven.registry.AetherEntities;
import paperdomo101.aether_rewoven.world.gen.surfacebuilder.AetherSurfaceBuilder;

public class AetherHighlandsBiome extends AetherBiome {

	public AetherHighlandsBiome() {
		super(new Biome.Settings().configureSurfaceBuilder(AetherSurfaceBuilder.AETHER, AetherSurfaceBuilder.AETHER_GRASS_CONFIG)
				.precipitation(Biome.Precipitation.NONE)
				.category(Biome.Category.NONE)
				.depth(0.1F)
				.scale(0.2F)
				.temperature(0.2F)
				.downfall(0.5F)
				.effects(new BiomeEffects.Builder().waterColor(6718662).waterFogColor(5004674).fogColor(12638463).build())
				.parent(null));
	}

	@Override
	protected void addSpawn(SpawnGroup group, SpawnEntry spawnEntry) {
		this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(AetherEntities.BLUE_SWET, 100, 1, 3));
		this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(AetherEntities.ZEPHYR, 40, 1, 2));
	}
}