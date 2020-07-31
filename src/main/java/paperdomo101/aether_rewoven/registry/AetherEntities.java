package paperdomo101.aether_rewoven.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.entity.boss.SliderEntity;
import paperdomo101.aether_rewoven.entity.mob.BlueSwetEntity;
import paperdomo101.aether_rewoven.entity.mob.TempestEntity;
import paperdomo101.aether_rewoven.entity.mob.ZephyrEntity;

public class AetherEntities {
    
    public static final EntityType<BlueSwetEntity> BLUE_SWET = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("blue_swet"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BlueSwetEntity::new).dimensions(EntityDimensions.changing(2.04F, 2.04F)).build()); 
    public static final EntityType<ZephyrEntity> ZEPHYR = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("zephyr"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ZephyrEntity::new).dimensions(EntityDimensions.fixed(2.5f, 1.8f)).trackable(100, 1, true).build()); 
    public static final EntityType<TempestEntity> TEMPEST = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("tempest"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TempestEntity::new).dimensions(EntityDimensions.fixed(2.5f, 1.8f)).trackable(100, 1, true).build()); 
    public static final EntityType<SliderEntity> SLIDER = Registry.register(Registry.ENTITY_TYPE, AetherRewoven.id("slider"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SliderEntity::new).dimensions(EntityDimensions.fixed(2.0f, 2.0f)).build());

    public static void init() {
        FabricDefaultAttributeRegistry.register(BLUE_SWET, BlueSwetEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ZEPHYR, ZephyrEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(TEMPEST, TempestEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SLIDER, SliderEntity.createMobAttributes());
    }
}