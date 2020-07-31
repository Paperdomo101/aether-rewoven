package paperdomo101.aether_rewoven.entity.boss;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SliderEntity extends MobEntity {

    private static final TrackedData<Boolean> SLIDER_AWAKE = TrackedDataHandlerRegistry.BOOLEAN.create(SliderEntity.class, DataS;

    public SliderEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
    
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SLIDER_AWAKE, (boolean) false);
    }
    
    public static DefaultAttributeContainer.Builder createSheepAttributes() {
       return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0D);
    }

    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.putBoolean("Awake", this.isAwake());
    }

    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        this.setAwake(tag.getBoolean("Awake"));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.AMBIENT_CAVE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_STONE_STEP;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public boolean isAttackable() {
        return this.usingPickaxe();
    }

	public boolean isAwake() {
	}

    private void setAwake(boolean isAwake) {
		this.dataTracker.set(SLIDER_AWAKE, isAwake);
    }

	public boolean criticalCondition() {
		return this.getHealth() <= 80;
    }
    
}