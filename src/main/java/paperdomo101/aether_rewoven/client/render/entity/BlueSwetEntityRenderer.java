package paperdomo101.aether_rewoven.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.SlimeEntityRenderer;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.entity.mob.BlueSwetEntity;

@Environment(EnvType.CLIENT)
public class BlueSwetEntityRenderer extends SlimeEntityRenderer {
    private static final Identifier TEXTURE = AetherRewoven.id("textures/entity/swet/blue_swet.png");

    public BlueSwetEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
        //this.addFeature(new SlimeOverlayFeatureRenderer<BlueSwetEntity>(this));
    }
    public Identifier getTexture(BlueSwetEntity blueSwetEntity) {
        return TEXTURE;
    }    
}