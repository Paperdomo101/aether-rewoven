package paperdomo101.aether_rewoven.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AetherDebugItem extends Item {

    public enum DebugItemType {
        portal,
    }

    public DebugItemType type;

    public AetherDebugItem(Settings settings, DebugItemType type) {
        super(settings);
        this.type = type;

    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        switch (type) {
            case portal:
                
                break;
        }
        return super.use(world, user, hand);
    }

}