package paperdomo101.aether_rewoven.world.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
				.temperature(0.4F)
				.downfall(0.5F)
				.effects(new BiomeEffects.Builder().waterColor(0x3d5480).waterFogColor(0x263e65).fogColor(12638463).build())
				.parent(null));
	}

	@Override
	protected void addSpawn(SpawnGroup group, SpawnEntry spawnEntry) {
		// this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(AetherEntities.BLUE_SWET, 100, 1, 3));
		this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(AetherEntities.ZEPHYR, 40, 1, 2));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(AetherEntities.PHYG, 40, 1, 2));
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public int getGrassColorAt(double p_225528_1_, double p_225528_3_) {
		return 0x79a88a;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getFoliageColor() {
		return 0x8dc950;
	}
}