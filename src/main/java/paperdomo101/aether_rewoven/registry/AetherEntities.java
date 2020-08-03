package paperdomo101.aether_rewoven.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.entity.boss.SliderEntity;
import paperdomo101.aether_rewoven.entity.mob.TempestEntity;
import paperdomo101.aether_rewoven.entity.mob.ZephyrEntity;

public class AetherEntities {
    
    //Passive
    public static final EntityType<PigEntity> PHYG = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("phyg"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PigEntity::new).dimensions(EntityDimensions.fixed(0.9f, 0.9f)).trackable(10, 1).build());

    //Hostile
    public static final EntityType<ZephyrEntity> ZEPHYR = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("zephyr"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ZephyrEntity::new).dimensions(EntityDimensions.fixed(2.5f, 1.8f)).trackable(100, 1, true).build()); 
    public static final EntityType<TempestEntity> TEMPEST = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("tempest"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TempestEntity::new).dimensions(EntityDimensions.fixed(2.5f, 1.8f)).trackable(100, 1, true).build()); 
    
    //Boss
    public static final EntityType<SliderEntity> SLIDER = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("slider"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SliderEntity::new).dimensions(EntityDimensions.fixed(2.0f, 2.0f)).build());
    
    //Projectile
    // public static EntityType<? extends ZephyrSnowballEntity> ZEPHYR_SNOWBALL = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("zephyr_snowball"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, ZephyrSnowballEntity::new).dimensions(EntityDimensions.fixed(0.1875f, 0.125f)).build());

    public static void init() {
        FabricDefaultAttributeRegistry.register(PHYG, PigEntity.createPigAttributes());
        FabricDefaultAttributeRegistry.register(ZEPHYR, ZephyrEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0D));
        FabricDefaultAttributeRegistry.register(TEMPEST, TempestEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0D));
        FabricDefaultAttributeRegistry.register(SLIDER, SliderEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0D));
    }
}