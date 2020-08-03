package paperdomo101.aether_rewoven.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.client.render.entity.model.SliderEntityModel;
import paperdomo101.aether_rewoven.entity.boss.SliderEntity;

@Environment(EnvType.CLIENT)
public class SliderGlowFeatureRenderer extends FeatureRenderer<SliderEntity, SliderEntityModel<SliderEntity>> {
    
    private static final RenderLayer TEXTURE_NONE = RenderLayer.getEyes(AetherRewoven.id("textures/entity/slider/none.png"));
    private static final RenderLayer TEXTURE_AWAKE_GLOW = RenderLayer.getEyes(AetherRewoven.id("textures/entity/slider/awake_glow.png"));
    private static final RenderLayer TEXTURE_AWAKE_CRITICAL_GLOW = RenderLayer.getEyes(AetherRewoven.id("textures/entity/slider/awake_critical_glow.png"));

    public SliderGlowFeatureRenderer(FeatureRendererContext<SliderEntity, SliderEntityModel<SliderEntity>> featureRendererContext) {
       super(featureRendererContext);
    }

    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, SliderEntity slider, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getGlowTexture(slider));
        if (slider.isAwake()) {
            this.getContextModel().render(matrices, vertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        } else {
            this.getContextModel().render(matrices, vertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 0.0F);
        }
    }

    private RenderLayer getGlowTexture(SliderEntity slider) {
        if (slider.isAwake()) {
            return slider.criticalCondition() ? TEXTURE_AWAKE_CRITICAL_GLOW : TEXTURE_AWAKE_GLOW;
        }
        return TEXTURE_AWAKE_GLOW;
    }
}