package paperdomo101.aether_rewoven.item;

import org.apache.logging.log4j.Level;

import io.netty.handler.logging.LogLevel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.AetherRewoven;

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
                
                
                user.changeDimension(
                    world.getServer().getWorld( 
                        world.getRegistryKey() == world.OVERWORLD ? world.NETHER : world.OVERWORLD  
                    )
                );

                break;
        
            default:
                break;
        }
    
        return super.use(world, user, hand);
    }

}