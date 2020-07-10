package paperdomo101.aether_rewoven.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;

@Environment(EnvType.CLIENT)
public class BanejoPotFragmentParticle extends SpriteBillboardParticle {

    public BanejoPotFragmentParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z);
        this.velocityX *= 0.10000000149011612D;
        this.velocityY *= 0.10000000149011612D;
        this.velocityZ *= 0.10000000149011612D;
        this.velocityX += velocityX * 0.4D;
        this.velocityY += velocityY * 0.4D;
        this.velocityZ += velocityZ * 0.4D;
        this.prevPosX = x + velocityX;
        this.prevPosY = y + velocityY;
        this.prevPosZ = z + velocityZ;
        this.x = this.prevPosX;
        this.y = this.prevPosY;
        this.z = this.prevPosZ;
        this.gravityStrength = 1.0F;
        this.collidesWithWorld = true;
        this.maxAge = (int)(Math.random() * 10.0D) + 30;
    }
    
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= 0.699999988079071D;
            this.velocityY *= 0.699999988079071D;
            this.velocityZ *= 0.699999988079071D;
            this.velocityY -= 0.019999999552965164D;
            if (this.onGround) {
                this.velocityX *= 0.0;
                this.velocityZ *= 0.0;
            }
        }
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }
    
}