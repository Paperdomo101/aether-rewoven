package paperdomo101.aether_rewoven.entity;

import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.block.AetherPortalBlock;
import paperdomo101.aether_rewoven.registry.AetherBlocks;
import paperdomo101.aether_rewoven.registry.AetherDimensions;

public class AetherEntityAdditions {
    
    public int aetherPortalCooldown;
    protected boolean inAetherPortal;
    protected int aetherPortalTime;
    protected BlockPos lastAetherPortalPosition;
    protected Vec3d lastAetherPortalDirectionVector;
    protected Direction lastAetherPortalDirection;
    protected Entity entity;

	public void tickAetherPortal() {
        if (entity.world instanceof ServerWorld) {
            int i = this.getMaxAetherPortalTime();
            ServerWorld serverWorld = (ServerWorld)this.entity.world;
            if (this.inAetherPortal) {
                MinecraftServer minecraftServer = serverWorld.getServer();
                RegistryKey<World> registryKey = this.entity.world.getRegistryKey() == AetherDimensions.AETHER ? World.OVERWORLD : AetherDimensions.AETHER;
                ServerWorld serverWorld2 = minecraftServer.getWorld(registryKey);
                if (serverWorld2 != null && minecraftServer.isNetherAllowed() && !entity.hasVehicle() && this.aetherPortalTime++ >= i) {
                    this.entity.world.getProfiler().push("portal");
                    this.aetherPortalTime = i;
                    this.aetherPortalCooldown = this.getDefaultAetherPortalCooldown();
                    this.entity.changeDimension(serverWorld2);
                    this.entity.world.getProfiler().pop();
                }
                this.inAetherPortal = false;
            } else {
                if (this.aetherPortalTime > 0) {
                    this.aetherPortalTime -= 4;
                }
            if (this.aetherPortalTime < 0) {
                this.aetherPortalTime = 0;
            }
        }

        this.tickAetherPortalCooldown();
        }
    }
    
    private int getDefaultAetherPortalCooldown() {
        return 300;
    }

    protected void tickAetherPortalCooldown() {
        if (this.aetherPortalCooldown > 0) {
        --this.aetherPortalCooldown;
        }
    }

    public int getMaxAetherPortalTime() {
        return 1;
    }

    public void setInAetherPortal(BlockPos pos, Entity entity) {
        if (this.aetherPortalCooldown > 0) {
            this.aetherPortalCooldown = this.getDefaultAetherPortalCooldown();
        } else {
            if (!entity.world.isClient && !pos.equals(this.lastAetherPortalPosition)) {
            this.lastAetherPortalPosition = new BlockPos(pos);
            AetherPortalBlock var10000 = (AetherPortalBlock)AetherBlocks.AETHER_PORTAL;
            BlockPattern.Result result = AetherPortalBlock.findPortal(entity.world, this.lastAetherPortalPosition);
            double d = result.getForwards().getAxis() == Direction.Axis.X ? (double)result.getFrontTopLeft().getZ() : (double)result.getFrontTopLeft().getX();
            double e = MathHelper.clamp(Math.abs(MathHelper.getLerpProgress((result.getForwards().getAxis() == Direction.Axis.X ? entity.getZ() : entity.getX()) - (double)(result.getForwards().rotateYClockwise().getDirection() == Direction.AxisDirection.NEGATIVE ? 1 : 0), d, d - (double)result.getWidth())), 0.0D, 1.0D);
            double f = MathHelper.clamp(MathHelper.getLerpProgress(entity.getY() - 1.0D, (double)result.getFrontTopLeft().getY(), (double)(result.getFrontTopLeft().getY() - result.getHeight())), 0.0D, 1.0D);
            this.lastAetherPortalDirectionVector = new Vec3d(e, f, 0.0D);
            this.lastAetherPortalDirection = result.getForwards();
            }

            this.inAetherPortal = true;
        }
    }
}