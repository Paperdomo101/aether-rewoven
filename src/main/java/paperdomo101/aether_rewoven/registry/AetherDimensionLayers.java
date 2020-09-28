package paperdomo101.aether_rewoven.registry;

import net.minecraft.world.dimension.DimensionType;
import paperdomo101.aether_rewoven.world.dimension.AetherEntityPlacer;
import paperdomo101.aether_rewoven.world.dimension.DimensionLayerRegistry;

public class AetherDimensionLayers {
    
    public static void init() {
        DimensionLayerRegistry.INSTANCE.register(DimensionLayerRegistry.Type.BOTTOM, AetherDimensions.THE_AETHER_REGISTRY_KEY, 0, DimensionType.OVERWORLD_REGISTRY_KEY, AetherEntityPlacer.FALL_FROM_AETHER);
    }
}