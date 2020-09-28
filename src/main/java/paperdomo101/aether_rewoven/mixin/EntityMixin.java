package paperdomo101.aether_rewoven.mixin;

import java.util.List;

import com.google.common.collect.Lists;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.entity.AetherEntityAdditions;
import paperdomo101.aether_rewoven.world.dimension.DimensionLayerRegistry;

@SuppressWarnings("deprecation")
@Mixin(Entity.class)
public abstract class EntityMixin implements AetherEntityAdditions {
   int lastY = 0;

	@Shadow
	public World world;

	@Unique
   Entity lastVehicle = null;
   
   // private final AetherEntityAdditions additions = new AetherEntityAdditions();

   
	@Override
	public Entity aether_rewoven_getLastVehicle() {
		return lastVehicle;
   }
   
	@Override
	public void aether_rewoven_setLastVehicle(Entity lastVehicle) {
		this.lastVehicle = lastVehicle;
	}

   @Inject(method = "baseTick", at = @At("HEAD"))
   private void baseTick() {
      // additions.tickAetherPortalCooldown();
   }

	@Inject(at = @At("HEAD"), method = "tickNetherPortal()V")
	void onTick(CallbackInfo callbackInformation) {
		Entity entity = (Entity) (Object) this;

		if ((int) entity.getPos().getY() != lastY && !entity.world.isClient && entity.getVehicle() == null) {
			lastY = (int) entity.getPos().getY();

			int bottomPortal = DimensionLayerRegistry.INSTANCE.getLevel(DimensionLayerRegistry.Type.BOTTOM, entity.world.getDimensionRegistryKey());
			int topPortal = DimensionLayerRegistry.INSTANCE.getLevel(DimensionLayerRegistry.Type.TOP, entity.world.getDimensionRegistryKey());

			if (lastY <= bottomPortal && bottomPortal != Integer.MIN_VALUE) {
				RegistryKey<World> worldKey = RegistryKey.of(Registry.DIMENSION, DimensionLayerRegistry.INSTANCE.getDimension(DimensionLayerRegistry.Type.BOTTOM, entity.world.getDimensionRegistryKey()).getValue());

				ServerWorld serverWorld = entity.world.getServer().getWorld(worldKey);

				List<Entity> existingPassengers = Lists.newArrayList(entity.getPassengerList());

				List<DataTracker.Entry<?>> entries = Lists.newArrayList();
				for (DataTracker.Entry<?> entry : entity.getDataTracker().getAllEntries()) {
					entries.add(entry.copy());
				}

				Entity newEntity = FabricDimensions.teleport(entity, serverWorld, DimensionLayerRegistry.INSTANCE.getPlacer(DimensionLayerRegistry.Type.BOTTOM, entity.world.getDimensionRegistryKey()));

				for (DataTracker.Entry entry : entries) {
					newEntity.getDataTracker().set(entry.getData(), entry.get());
				}

				for (Entity existingEntity : existingPassengers) {
					((AetherEntityAdditions) existingEntity).aether_rewoven_setLastVehicle(newEntity);
				}
			} else if (lastY >= topPortal && topPortal != Integer.MIN_VALUE) {
				RegistryKey<World> worldKey = RegistryKey.of(Registry.DIMENSION, DimensionLayerRegistry.INSTANCE.getDimension(DimensionLayerRegistry.Type.TOP, entity.world.getDimensionRegistryKey()).getValue());

				ServerWorld serverWorld = entity.world.getServer().getWorld(worldKey);

				List<Entity> existingPassengers = Lists.newArrayList(entity.getPassengerList());

				List<DataTracker.Entry<?>> entries = Lists.newArrayList();
				for (DataTracker.Entry<?> entry : entity.getDataTracker().getAllEntries()) {
					entries.add(entry.copy());
				}

				Entity newEntity = FabricDimensions.teleport(entity, serverWorld, DimensionLayerRegistry.INSTANCE.getPlacer(DimensionLayerRegistry.Type.TOP, entity.world.getDimensionRegistryKey()));

				for (DataTracker.Entry entry : entries) {
					newEntity.getDataTracker().set(entry.getData(), entry.get());
				}

				for (Entity existingEntity : existingPassengers) {
					((AetherEntityAdditions) existingEntity).aether_rewoven_setLastVehicle(newEntity);
				}
			}
		}

		if (entity.getVehicle() != null)
			lastVehicle = null;
		if (lastVehicle != null) {
			if (lastVehicle.getEntityWorld().getRegistryKey().equals(entity.getEntityWorld().getRegistryKey())) {
				entity.startRiding(lastVehicle);
				lastVehicle = null;
			}
      }
   }


   // @Inject(method = "toTag", at = @At("HEAD"))
   // private CompoundTag toTag(CompoundTag tag) {
   //    tag.putInt("AetherPortalCooldown", additions.aetherPortalCooldown);
   //    return tag;
   // }
}