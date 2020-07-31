package paperdomo101.aether_rewoven.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.client.render.entity.model.SliderEntityModel;
import paperdomo101.aether_rewoven.entity.boss.SliderEntity;

@Environment(EnvType.CLIENT)
public class SliderGlowFeatureRenderer<T extends SliderEntity> extends EyesFeatureRenderer<T, SliderEntityModel<T>> {
    private static final RenderLayer TEXTURE_NONE = RenderLayer.getEyes(AetherRewoven.id("textures/entity/slider/none.png"));
    private static final RenderLayer TEXTURE_AWAKE_GLOW = RenderLayer.getEyes(AetherRewoven.id("textures/entity/slider/slider_awake_glow.png"));
    private static final RenderLayer TEXTURE_AWAKE_CRITICAL_GLOW = RenderLayer.getEyes(AetherRewoven.id("textures/entity/slider/slider_awake_critical_glow.png"));

    public SliderGlowFeatureRenderer(FeatureRendererContext<T, SliderEntityModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return this.getStatus();
    }

    private RenderLayer getStatus() {
        if (SliderEntity.isAwake()) {
            return SliderEntity.criticalCondition() ? TEXTURE_AWAKE_CRITICAL_GLOW : TEXTURE_AWAKE_GLOW;
        }
        return TEXTURE_NONE;
    }
}