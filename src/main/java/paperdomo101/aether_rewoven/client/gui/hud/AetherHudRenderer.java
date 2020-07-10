package paperdomo101.aether_rewoven.client.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import paperdomo101.aether_rewoven.registry.AetherBlocks;

@Environment(EnvType.CLIENT)
public class AetherHudRenderer extends DrawableHelper {

    private MinecraftClient client;
    private int scaledWidth;
    private int scaledHeight;
    
    public void render(MatrixStack ms, float partial, MinecraftClient client) {
        this.client = client;
        this.renderAetherPortalOverlay(partial);
        float q;
        q = MathHelper.lerp(partial, this.client.player.lastNauseaStrength, this.client.player.nextNauseaStrength);
        if (q > 0.0F) {
            this.renderAetherPortalOverlay(q);
        }
    }

    private void renderAetherPortalOverlay(float f) {
        RenderSystem.disableAlphaTest();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, f);
        this.client.getTextureManager().bindTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEX);
        Sprite sprite = this.client.getBlockRenderManager().getModels().getSprite(AetherBlocks.AETHER_PORTAL.getDefaultState());
        float g = sprite.getMinU();
        float h = sprite.getMinV();
        float i = sprite.getMaxU();
        float j = sprite.getMaxV();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(0.0D, (double)this.scaledHeight, -90.0D).texture(g, j).next();
        bufferBuilder.vertex((double)this.scaledWidth, (double)this.scaledHeight, -90.0D).texture(i, j).next();
        bufferBuilder.vertex((double)this.scaledWidth, 0.0D, -90.0D).texture(i, h).next();
        bufferBuilder.vertex(0.0D, 0.0D, -90.0D).texture(g, h).next();
        tessellator.draw();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.enableAlphaTest();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
    
}