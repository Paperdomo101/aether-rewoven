package paperdomo101.aether_rewoven.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class AmbrosiumDustParticle extends AnimatedParticle {

    protected AmbrosiumDustParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, spriteProvider, 0.0F);
        this.scale = 0.1F;
        this.setColorAlpha(1.0F);
        this.setColor(0.89F, 0.89F, 0.329F);
        this.maxAge = (int)((double)(this.scale * 12.0F) / (Math.random() * 0.800000011920929D + 0.20000000298023224D));
        this.setSpriteForAge(spriteProvider);
        this.collidesWithWorld = false;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.setResistance(0.0F);
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.setSpriteForAge(this.spriteProvider);
            if (this.age > this.maxAge / 2) {
                this.setColorAlpha(1.0F - ((float)this.age - (float)(this.maxAge / 2)) / (float)this.maxAge);
            }

            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.world.getBlockState(new BlockPos(this.x, this.y, this.z)).isAir()) {
                this.velocityY -= 0.00800000037997961D;
            }

            this.velocityX *= 0.9200000166893005D;
            this.velocityY *= 0.9200000166893005D;
            this.velocityZ *= 0.9200000166893005D;
            if (this.onGround) {
                this.velocityX *= 0.699999988079071D;
                this.velocityZ *= 0.699999988079071D;
            }

        }
    }
}