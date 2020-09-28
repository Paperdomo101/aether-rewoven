package paperdomo101.aether_rewoven.item;

import org.apache.logging.log4j.Level;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.registry.AetherDimensions;
import paperdomo101.aether_rewoven.world.dimension.AetherEntityPlacer;

@SuppressWarnings("deprecation")
public class AetherDebugItem extends Item {

    public enum DebugItemType {
        portal,
    }

    DebugItemType type;

    public AetherDebugItem(Settings settings, DebugItemType type) {
        super(settings);
    this.type = type;
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.world.isClient) {return super.use(world, user, hand);}

        switch (type) {
            case portal:
                AetherRewoven.log(Level.INFO, "Portal Debug Item");
                // AetherRewoven.log(Level.WARN, "Does not yet have an Aether PlayerPlacer");
                
                
                ServerWorld dest = world.getServer().getWorld( world.getRegistryKey() == AetherDimensions.AETHER ? World.OVERWORLD : AetherDimensions.AETHER);
                
                FabricDimensions.teleport((ServerPlayerEntity)(user), dest, AetherEntityPlacer.CREATE_PORTAL);

                break;
        
            default:
                break;
        }
    
        return super.use(world, user, hand);
    }

}