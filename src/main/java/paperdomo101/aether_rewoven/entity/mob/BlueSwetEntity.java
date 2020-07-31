package paperdomo101.aether_rewoven.entity.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import paperdomo101.aether_rewoven.registry.AetherBiomes;

public class BlueSwetEntity extends SlimeEntity {
   
   public BlueSwetEntity(EntityType<BlueSwetEntity> type, World world) {
      super(type, world);
   }
   
   @Override
   public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
      BlockPos pos = getBlockPos().down();
      boolean canSpawn = world.getBiome(pos) == AetherBiomes.AETHER_HIGHLANDS && (spawnReason == SpawnReason.SPAWNER || world.getBlockState(pos).allowsSpawning(world, pos, getType()));
      return canSpawn;
   }

   @Override
   protected boolean isDisallowedInPeaceful() {
      return true;
   }

   @Override
   protected ParticleEffect getParticles() {
      return ParticleTypes.SPLASH;
   }
}
