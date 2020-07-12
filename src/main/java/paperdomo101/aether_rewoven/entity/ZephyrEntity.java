package paperdomo101.aether_rewoven.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ZephyrEntity extends FlyingEntity implements Monster {
    private static final TrackedData<Boolean> SHOOTING;
    private int fireballStrength = 1;

    public ZephyrEntity(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    protected void initGoals() {
        this.goalSelector.add(5, new ZephyrEntity.FlyRandomlyGoal(this));
        this.goalSelector.add(7, new ZephyrEntity.LookAtTargetGoal(this));
        this.goalSelector.add(7, new ZephyrEntity.ShootFireballGoal(this));
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, 10, true, false, (livingEntity) -> {
        return Math.abs(livingEntity.getY() - this.getY()) <= 4.0D;
        }));
    }
    
}