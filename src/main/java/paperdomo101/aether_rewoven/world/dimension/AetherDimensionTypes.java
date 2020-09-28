package paperdomo101.aether_rewoven.world.dimension;

import java.util.OptionalLong;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.source.VoronoiBiomeAccessType;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.registry.AetherDimensions;
import paperdomo101.aether_rewoven.tag.AetherBlockTags;

@SuppressWarnings("deprecation")
public class AetherDimensionTypes extends DimensionType {
    public static final RegistryKey<DimensionOptions> THE_AETHER_OPTIONS = RegistryKey.of(Registry.DIMENSION_OPTIONS, AetherRewoven.id("the_aether"));
    public static final RegistryKey<DimensionType> THE_AETHER_REGISTRY_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, AetherRewoven.id("the_aether"));
    
    public static final DimensionType INSTANCE = new AetherDimensionTypes();

    protected AetherDimensionTypes() {
      super(OptionalLong.empty(), true, false, false, true, false, false, false, true, true, false, 256, VoronoiBiomeAccessType.INSTANCE, AetherBlockTags.INFINIBURN_AETHER.getId(), 0.0f);
      FabricDimensions.registerDefaultPlacer(AetherDimensions.AETHER, AetherEntityPlacer.CREATE_PORTAL);
    }
}