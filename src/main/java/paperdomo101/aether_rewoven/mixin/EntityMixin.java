package paperdomo101.aether_rewoven.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import paperdomo101.aether_rewoven.entity.AetherEntityAdditions;

@Mixin(Entity.class)
public class EntityMixin {

   private final AetherEntityAdditions additions = new AetherEntityAdditions();

   @Inject(method = "baseTick", at = @At("HEAD"))
   private void baseTick() {
      //additions.tickAetherPortal(null);
   }


   @Inject(method = "toTag", at = @At("HEAD"))
   private CompoundTag toTag(CompoundTag tag) {
      tag.putInt("AetherPortalCooldown", additions.aetherPortalCooldown);
      return tag;
   }
}