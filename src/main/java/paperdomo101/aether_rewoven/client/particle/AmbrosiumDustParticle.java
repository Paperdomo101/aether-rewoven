package paperdomo101.aether_rewoven.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;

@Environment(EnvType.CLIENT)
public class AmbrosiumDustParticle extends AnimatedParticle {
    private final double startX;
    private final double startY;
    private final double startZ;
    
    protected AmbrosiumDustParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, spriteProvider, 0.0F);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.x = x;
        this.y = y;
        this.z = z;
        this.startX = this.x;
        this.startY = this.y;
        this.startZ = this.z;
        this.scale = (float)((double)this.scale * 1.5D);
        float j = this.random.nextFloat() * 0.6F + 0.4F;
        this.colorRed = j * 0.7F;
        this.colorGreen = j * 0.7F;
        this.colorBlue = j * 0.1F;
        // this.setColorAlpha(1.0F);
        // this.setColor(0.89F, 0.79F, 0.329F);
        this.maxAge = (int)(Math.random() * 2.0D) + 60;
        // this.setSpriteForAge(spriteProvider);
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }
    
    public void move(double dx, double dy, double dz) {
        this.setBoundingBox(this.getBoundingBox().offset(dx, dy, dz));
        this.repositionFromBoundingBox();
    }

    public int getColorMultiplier(float tint) {
        int i = super.getColorMultiplier(tint);
        float f = (float)this.age / (float)this.maxAge;
        f *= f;
        f *= f;
        int j = i & 255;
        int k = i >> 16 & 255;
        k += (int)(f * 15.0F * 16.0F);
        if (k > 240) {
        k = 240;
        }

        return j | k << 16;
    }

    public float getSize(float tickDelta) {
        float f = 1.0F - ((float)this.age + tickDelta) / ((float)this.maxAge * 1.5F);
        return this.scale * f;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            float f = (float)this.age / (float)this.maxAge;
            this.x += this.velocityX * (double)f;
            this.y += this.velocityY * (double)f;
            this.z += this.velocityZ * (double)f;
        }
    }
}