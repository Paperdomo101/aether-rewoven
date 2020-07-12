package paperdomo101.aether_rewoven.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SlimeOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.AetherRewoven;

@Environment(EnvType.CLIENT)
public class BlueSwetEntityRenderer extends MobEntityRenderer<SlimeEntity, SlimeEntityModel<SlimeEntity>> {
    private static final Identifier TEXTURE = AetherRewoven.id("textures/entity/swet/blue_swet.png");

    public BlueSwetEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, SlimeEntityModel<SlimeEntity> entityModel, float f) {
        super(entityRenderDispatcher, new SlimeEntityModel<SlimeEntity>(0), 1.5f);
        this.addFeature(new SlimeOverlayFeatureRenderer<SlimeEntity>(this));
    }

    @Override
    public Identifier getTexture(SlimeEntity zephyrEntity) {
        return TEXTURE;
    }    

    protected void scale(SlimeEntity zephyrEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(2.0F, 2.0F, 2.0F);
    }
}