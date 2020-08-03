package paperdomo101.aether_rewoven.world.biome.source;

import java.util.function.LongFunction;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.util.CachingLayerContext;
import net.minecraft.world.biome.layer.util.LayerFactory;
import net.minecraft.world.biome.layer.util.LayerSampleContext;
import net.minecraft.world.biome.layer.util.LayerSampler;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import paperdomo101.aether_rewoven.world.biome.layer.AetherBiomeLayer;

public class AetherBiomeSource extends BiomeSource {
	public static Codec<AetherBiomeSource> CODEC = Codec.LONG.fieldOf("seed").xmap(AetherBiomeSource::new, (source) -> source.seed).stable().codec();
	private final long seed;
	private final BiomeLayerSampler sampler;

	public AetherBiomeSource(long seed) {
		super(ImmutableList.of());
		this.seed = seed;
		this.sampler = build(seed);
	}

	@Override
	protected Codec<? extends BiomeSource> method_28442() {
		return CODEC;
	}

	@Override
	public BiomeSource withSeed(long seed) {
		return new AetherBiomeSource(seed);
	}

	@Override
	public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
		return sampler.sample(biomeX, biomeZ);
	}

	public static BiomeLayerSampler build(long seed) {
		return new BiomeLayerSampler(build((salt) -> new CachingLayerContext(25, seed, salt)));
	}

	private static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T> build(LongFunction<C> contextProvider) {
		LayerFactory<T> mainLayer = AetherBiomeLayer.INSTANCE.create(contextProvider.apply(4L));
		for (int i = 0; i < 5; i++) {
			mainLayer = ScaleLayer.FUZZY.create(contextProvider.apply(43 + i), mainLayer);
		}

		return mainLayer;
	}
}