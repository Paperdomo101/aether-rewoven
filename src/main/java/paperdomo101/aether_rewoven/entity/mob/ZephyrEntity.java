package paperdomo101.aether_rewoven.entity.mob;

import java.util.EnumSet;
import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import paperdomo101.aether_rewoven.entity.projectile.ZephyrSnowballEntity;
import paperdomo101.aether_rewoven.registry.AetherSounds;

public class ZephyrEntity extends FlyingEntity implements Monster {
    private static final TrackedData<Boolean> SHOOTING;

    public ZephyrEntity(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
        this.moveControl = new ZephyrEntity.ZephyrMoveControl(this);
    }

    /*
    @Override
    public void setPos(double x, double y, double z) {
        this.lastRenderX = this.prevX = this.serverX = x;
        this.lastRenderY = this.prevY = this.serverY = y + 50;
        this.lastRenderZ = this.prevZ = this.serverZ = z;
        this.setPos(this.serverX, this.serverY, this.serverZ);
    }

    @Override
    public void setRotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }*/

    @Override
    protected void initGoals() {
        this.goalSelector.add(5, new ZephyrEntity.FlyRandomlyGoal(this));
        this.goalSelector.add(7, new ZephyrEntity.LookAtTargetGoal(this));
        this.goalSelector.add(7, new ZephyrEntity.ShootSnowballGoal(this));
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, 10, true, false, (livingEntity) -> {
           return Math.abs(((Entity) livingEntity).getY() - this.getY()) <= 4.0D;
        }));
    }

    @Environment(EnvType.CLIENT)
    public boolean isShooting() {
        return (Boolean)this.dataTracker.get(SHOOTING);
    }

    public void setShooting(boolean shooting) {
        this.dataTracker.set(SHOOTING, shooting);
    }

    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SHOOTING, false);
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return AetherSounds.ZEPHYR_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AetherSounds.ZEPHYR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AetherSounds.ZEPHYR_DEATH;
    }

    protected SoundEvent getShootSound(DamageSource source) {
        return AetherSounds.ZEPHYR_SHOOT;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return true;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0f;
    }

    public static boolean canSpawn(EntityType<ZephyrEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getLightLevel(pos) > 8 && world.getDifficulty() != Difficulty.PEACEFUL && random.nextInt(20) == 0 && canMobSpawn(type, world, spawnReason, pos, random);
    }

    @Override
    public int getLimitPerChunk() {
        return 1;
    }

    static {
        SHOOTING = DataTracker.registerData(ZephyrEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
    
    static class ShootSnowballGoal extends Goal {
        private final ZephyrEntity zephyr;
        public int cooldown;

        public ShootSnowballGoal(ZephyrEntity zephyr) {
            this.zephyr = zephyr;
        }

        public boolean canStart() {
            return this.zephyr.getTarget() != null;
        }

        public void start() {
            this.cooldown = 0;
        }

        public void stop() {
            this.zephyr.setShooting(false);
        }

        public void tick() {
            LivingEntity livingEntity = this.zephyr.getTarget();
            if (livingEntity.squaredDistanceTo(this.zephyr) < 4096.0D && this.zephyr.canSee(livingEntity)) {
                World world = this.zephyr.world;
                ++this.cooldown;
                if (this.cooldown == 10 && !this.zephyr.isSilent()) {
                    world.playSoundFromEntity((PlayerEntity) this.zephyr.getTarget(), zephyr, AetherSounds.ZEPHYR_AMBIENT, SoundCategory.HOSTILE, 3.0F, 1.0f);
                }
                if (this.cooldown == 20) {
                    Vec3d vec3d = this.zephyr.getRotationVec(1.0F);
                    double f = livingEntity.getX() - (this.zephyr.getX() + vec3d.x * 4.0D);
                    double g = livingEntity.getBodyY(0.5D) - (0.5D + this.zephyr.getBodyY(0.5D));
                    double h = livingEntity.getZ() - (this.zephyr.getZ() + vec3d.z * 4.0D);
                    if (!this.zephyr.isSilent()) {
                        world.playSoundFromEntity((PlayerEntity) this.zephyr.getTarget(), zephyr, AetherSounds.ZEPHYR_SHOOT, SoundCategory.HOSTILE, 3.0F, 1.0f);
                    }

                    SnowballEntity snowballEntity = new SnowballEntity(world, f, g, h);
                    snowballEntity.updatePosition(this.zephyr.getX() + vec3d.x * 4.0D, this.zephyr.getBodyY(0.5D) + 0.5D, snowballEntity.getZ() + vec3d.z * 4.0D);
                    world.spawnEntity(snowballEntity);
                    this.cooldown = -40;
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }
            this.zephyr.setShooting(this.cooldown > 10);
        }
    }

    static class LookAtTargetGoal extends Goal {
        private final ZephyrEntity zephyr;

        public LookAtTargetGoal(ZephyrEntity zephyr) {
        this.zephyr = zephyr;
        this.setControls(EnumSet.of(Goal.Control.LOOK));
        }

        public boolean canStart() {
        return true;
        }

        public void tick() {
            if (this.zephyr.getTarget() == null) {
                Vec3d vec3d = this.zephyr.getVelocity();
                this.zephyr.yaw = -((float)MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776F;
                this.zephyr.bodyYaw = this.zephyr.yaw;
            } else {
                LivingEntity livingEntity = this.zephyr.getTarget();
                if (livingEntity.squaredDistanceTo(this.zephyr) < 4096.0D) {
                    double e = livingEntity.getX() - this.zephyr.getX();
                    double f = livingEntity.getZ() - this.zephyr.getZ();
                    this.zephyr.yaw = -((float)MathHelper.atan2(e, f)) * 57.295776F;
                    this.zephyr.bodyYaw = this.zephyr.yaw;
                }
            }
        }
    }

    static class FlyRandomlyGoal extends Goal {

        private final ZephyrEntity zephyr;

        public FlyRandomlyGoal(ZephyrEntity zephyr) {
            this.zephyr = zephyr;
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        public boolean canStart() {
            MoveControl moveControl = this.zephyr.getMoveControl();
            if (!moveControl.isMoving()) {
            return true;
            } else {
            double d = moveControl.getTargetX() - this.zephyr.getX();
            double e = moveControl.getTargetY() - this.zephyr.getY();
            double f = moveControl.getTargetZ() - this.zephyr.getZ();
            double g = d * d + e * e + f * f;
            return g < 1.0D || g > 3600.0D;
            }
        }

        public boolean shouldContinue() {
            return false;
        }

        public void start() {
            Random random = this.zephyr.getRandom();
            double d = this.zephyr.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double e = this.zephyr.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double f = this.zephyr.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.zephyr.getMoveControl().moveTo(d, e, f, 1.0D);
        }
    }

    static class ZephyrMoveControl extends MoveControl {
        private final ZephyrEntity zephyr;
        private int collisionCheckCooldown;

        public ZephyrMoveControl(ZephyrEntity zephyr) {
            super(zephyr);
            this.zephyr = zephyr;
        }

        public void tick() {
            if (this.state == MoveControl.State.MOVE_TO) {
                if (this.collisionCheckCooldown-- <= 0) {
                    this.collisionCheckCooldown += this.zephyr.getRandom().nextInt(5) + 2;
                    Vec3d vec3d = new Vec3d(this.targetX - this.zephyr.getX(), this.targetY - this.zephyr.getY(), this.targetZ - this.zephyr.getZ());
                    double d = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.willCollide(vec3d, MathHelper.ceil(d))) {
                    this.zephyr.setVelocity(this.zephyr.getVelocity().add(vec3d.multiply(0.1D)));
                    } else {
                    this.state = MoveControl.State.WAIT;
                    }
                }

            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.zephyr.getBoundingBox();

            for(int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.zephyr.world.doesNotCollide(this.zephyr, box)) {
                    return false;
                }
            }

            return true;
        }
    }
}