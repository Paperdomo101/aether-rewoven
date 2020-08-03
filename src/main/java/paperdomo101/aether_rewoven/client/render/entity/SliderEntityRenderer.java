package paperdomo101.aether_rewoven.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.client.render.entity.feature.SliderGlowFeatureRenderer;
import paperdomo101.aether_rewoven.client.render.entity.model.SliderEntityModel;
import paperdomo101.aether_rewoven.entity.boss.SliderEntity;

@Environment(EnvType.CLIENT)
public class SliderEntityRenderer extends MobEntityRenderer<SliderEntity, SliderEntityModel<SliderEntity>> {
    private static final Identifier TEXTURE_ASLEEP = AetherRewoven.id("textures/entity/slider/asleep.png");
    private static final Identifier TEXTURE_AWAKE = AetherRewoven.id("textures/entity/slider/awake.png");
    private static final Identifier TEXTURE_ASLEEP_CRITICAL = AetherRewoven.id("textures/entity/slider/asleep_critical.png");
    private static final Identifier TEXTURE_AWAKE_CRITICAL = AetherRewoven.id("textures/entity/slider/awake_critical.png");

    public SliderEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new SliderEntityModel<>(), 1.5f);
        this.addFeature(new SliderGlowFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(SliderEntity slider) {
        if (slider.isAwake()) {
            return slider.criticalCondition() ? TEXTURE_AWAKE_CRITICAL : TEXTURE_AWAKE;
        }
        return slider.criticalCondition() ? TEXTURE_ASLEEP_CRITICAL : TEXTURE_ASLEEP;
    }
    
}