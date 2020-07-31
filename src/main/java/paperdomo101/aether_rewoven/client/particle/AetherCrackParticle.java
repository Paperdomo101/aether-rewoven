package paperdomo101.aether_rewoven.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public class AetherCrackParticle extends SpriteBillboardParticle {
    private final float sampleU;
    private final float sampleV;
 
    public AetherCrackParticle(ClientWorld world, double x, double y, double z, double d, double e, double f, ItemStack stack) {
       this(world, x, y, z, stack);
       this.velocityX *= 0.10000000149011612D;
       this.velocityY *= 0.10000000149011612D;
       this.velocityZ *= 0.10000000149011612D;
       this.velocityX += d;
       this.velocityY += e;
       this.velocityZ += f;
    }
 
    public ParticleTextureSheet getType() {
       return ParticleTextureSheet.TERRAIN_SHEET;
    }
 
    public AetherCrackParticle(ClientWorld world, double x, double y, double z, ItemStack stack) {
       super(world, x, y, z, 0.0D, 0.0D, 0.0D);
       this.setSprite(MinecraftClient.getInstance().getItemRenderer().getHeldItemModel(stack, world, (LivingEntity)null).getSprite());
       this.gravityStrength = 1.0F;
       this.scale /= 2.0F;
       this.sampleU = this.random.nextFloat() * 3.0F;
       this.sampleV = this.random.nextFloat() * 3.0F;
    }
 
    protected float getMinU() {
       return this.sprite.getFrameU((double)((this.sampleU + 1.0F) / 4.0F * 16.0F));
    }
 
    protected float getMaxU() {
       return this.sprite.getFrameU((double)(this.sampleU / 4.0F * 16.0F));
    }
 
    protected float getMinV() {
       return this.sprite.getFrameV((double)(this.sampleV / 4.0F * 16.0F));
    }
 
    protected float getMaxV() {
       return this.sprite.getFrameV((double)((this.sampleV + 1.0F) / 4.0F * 16.0F));
    }
}
 