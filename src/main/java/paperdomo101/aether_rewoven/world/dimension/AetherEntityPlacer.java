package paperdomo101.aether_rewoven.world.dimension;

import net.fabricmc.fabric.api.dimension.v1.EntityPlacer;
import net.minecraft.block.pattern.BlockPattern.TeleportTarget;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Direction;

@SuppressWarnings("deprecation")
public class AetherEntityPlacer implements EntityPlacer {

    @Override
    public TeleportTarget placeEntity(Entity teleported, ServerWorld destination, Direction portalDir, double horizontalOffset, double verticalOffset) {
        TeleportTarget tt = new TeleportTarget(teleported.getPos(), teleported.getVelocity(), (int)teleported.yaw);
        
        
        
        return tt;
    }
}