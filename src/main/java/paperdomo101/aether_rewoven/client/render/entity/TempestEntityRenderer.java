package paperdomo101.aether_rewoven.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.client.render.entity.feature.TempestGlowFeatureRenderer;
import paperdomo101.aether_rewoven.client.render.entity.feature.ZephyrOverlayFeatureRenderer;
import paperdomo101.aether_rewoven.client.render.entity.model.ZephyrEntityModel;
import paperdomo101.aether_rewoven.entity.mob.TempestEntity;

@Environment(EnvType.CLIENT)
public class TempestEntityRenderer extends MobEntityRenderer<TempestEntity, ZephyrEntityModel<TempestEntity>> {
    private static final Identifier TEXTURE = AetherRewoven.id("textures/entity/tempest/tempest.png");

    public TempestEntityRenderer(EntityRenderDispatcher entityRenderDispatcher,
        ZephyrEntityModel<TempestEntity> entityModel, float f) {
        super(entityRenderDispatcher, new ZephyrEntityModel<TempestEntity>(true), 1.5f);
        this.addFeature(new ZephyrOverlayFeatureRenderer<TempestEntity>(this));
        this.addFeature(new TempestGlowFeatureRenderer<TempestEntity>(this));
    }

    @Override
    public Identifier getTexture(TempestEntity tempestEntity) {
        return TEXTURE;
    }    

    protected void scale(TempestEntity tempestEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(4.5F, 4.5F, 4.5F);
    }
}