package paperdomo101.aether_rewoven.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.entity.LivingEntity;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.client.render.entity.model.ZephyrEntityModel;

@Environment(EnvType.CLIENT)
public class TempestGlowFeatureRenderer <T extends LivingEntity> extends EyesFeatureRenderer<T, ZephyrEntityModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(AetherRewoven.id("textures/entity/tempest/tempest_glow.png"));
    
    public TempestGlowFeatureRenderer(FeatureRendererContext<T, ZephyrEntityModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}