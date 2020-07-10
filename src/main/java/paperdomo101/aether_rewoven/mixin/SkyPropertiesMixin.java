package paperdomo101.aether_rewoven.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionType;

@Mixin(SkyProperties.class)
public interface SkyPropertiesMixin {

    @Accessor("BY_DIMENSION_TYPE")
    public Object2ObjectMap<RegistryKey<DimensionType>, SkyProperties> getBY_DIMENSION_TYPE();
}