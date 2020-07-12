package paperdomo101.aether_rewoven.entity.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.registry.AetherSounds;

public class TempestEntity extends FlyingEntity implements Monster {
    // private static final TrackedData<Boolean> SHOOTING;

    public TempestEntity(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER;
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

    @Override
    public int getLimitPerChunk() {
        return 1;
    }

    // protected void initGoals() {
    // this.goalSelector.add(5, new ZephyrEntity.FlyRandomlyGoal(this));
    // this.goalSelector.add(7, new ZephyrEntity.LookAtTargetGoal(this));
    // this.goalSelector.add(7, new ZephyrEntity.ShootFireballGoal(this));
    // this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, 10, true, false, (livingEntity) -> {
    // return Math.abs(livingEntity.getY() - this.getY()) <= 4.0D;
    // }));
    // }

    // @Environment(EnvType.CLIENT)
    // public boolean isShooting() {
    //     return (Boolean)this.dataTracker.get(SHOOTING);
    // }

    // public void setShooting(boolean shooting) {
    //     this.dataTracker.set(SHOOTING, shooting);
    // }

    // protected boolean isDisallowedInPeaceful() {
    //     return true;
    // }

    // public class FlyRandomlyGoal {
    // }

    // public class LookAtTargetGoal {
    // }

    // public class ShootFireballGoal {
    // }
    
}