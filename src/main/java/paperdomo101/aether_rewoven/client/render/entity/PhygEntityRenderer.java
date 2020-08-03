package paperdomo101.aether_rewoven.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.AetherRewoven;

@Environment(EnvType.CLIENT)
public class PhygEntityRenderer extends MobEntityRenderer<PigEntity, PigEntityModel<PigEntity>> {
    private static final Identifier TEXTURE = AetherRewoven.id("textures/entity/phyg/phyg.png");

    public PhygEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PigEntityModel<>(), 0.7F);
        this.addFeature(new SaddleFeatureRenderer<>(this, new PigEntityModel<>(0.5F), AetherRewoven.id("textures/entity/phyg/phyg_saddle.png")));
    }

    public Identifier getTexture(PigEntity pigEntity) {
        return TEXTURE;
    }
}
