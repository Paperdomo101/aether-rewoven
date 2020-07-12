package paperdomo101.aether_rewoven.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.client.render.entity.feature.ZephyrOverlayFeatureRenderer;
import paperdomo101.aether_rewoven.client.render.entity.model.ZephyrEntityModel;
import paperdomo101.aether_rewoven.entity.mob.ZephyrEntity;

@Environment(EnvType.CLIENT)
public class ZephyrEntityRenderer extends MobEntityRenderer<ZephyrEntity, ZephyrEntityModel<ZephyrEntity>> {
    private static final Identifier TEXTURE = AetherRewoven.id("textures/entity/zephyr.png");

    public ZephyrEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, ZephyrEntityModel<ZephyrEntity> entityModel, float f) {
        super(entityRenderDispatcher, new ZephyrEntityModel<ZephyrEntity>(true), 1.5f);
        this.addFeature(new ZephyrOverlayFeatureRenderer<ZephyrEntity>(this));
    }

    @Override
    public Identifier getTexture(ZephyrEntity zephyrEntity) {
        return TEXTURE;
    }    

    protected void scale(ZephyrEntity zephyrEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(4.5F, 4.5F, 4.5F);
    }
}