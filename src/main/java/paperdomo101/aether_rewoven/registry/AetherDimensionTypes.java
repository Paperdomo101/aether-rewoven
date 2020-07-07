package paperdomo101.aether_rewoven.registry;

import java.util.OptionalLong;

import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.source.VoronoiBiomeAccessType;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import paperdomo101.aether_rewoven.AetherRewoven;

public class AetherDimensionTypes extends DimensionType {

	public static final RegistryKey<DimensionOptions> AETHER = RegistryKey.of(Registry.DIMENSION_OPTIONS,AetherRewoven.id("the_aether"));
	public static final RegistryKey<DimensionType> THE_AETHER = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, AetherRewoven.id("the_aether"));

	public static final DimensionType INSTANCE = new AetherDimensionTypes();

	protected AetherDimensionTypes() {
		super(OptionalLong.of(15000L), false, true, false, false, false, false, false, false, true, false, 256, VoronoiBiomeAccessType.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getId(), 0.0F);
	}
}