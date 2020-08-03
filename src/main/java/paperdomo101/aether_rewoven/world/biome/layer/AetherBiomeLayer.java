package paperdomo101.aether_rewoven.world.biome.layer;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.IdentityCoordinateTransformer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import paperdomo101.aether_rewoven.registry.AetherBiomes;

public enum AetherBiomeLayer implements InitLayer, IdentityCoordinateTransformer {
	INSTANCE;

	@Override
	public int sample(LayerRandomnessSource context, int x, int y) {
		switch (context.nextInt(3)) {
			case 0:
				return Registry.BIOME.getRawId(AetherBiomes.AETHER_HIGHLANDS);
			case 1:
				return Registry.BIOME.getRawId(AetherBiomes.AETHER_HIGHLANDS);
			case 2:
				return Registry.BIOME.getRawId(AetherBiomes.AETHER_HIGHLANDS);
		}

		return Registry.BIOME.getRawId(AetherBiomes.AETHER_HIGHLANDS);
	}
}