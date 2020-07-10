package paperdomo101.aether_rewoven.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.GlobalTagAccessor;
import net.minecraft.tag.Tag;

public class AetherBlockTags {
    private static final GlobalTagAccessor<Block> ACCESSOR = new GlobalTagAccessor<Block>();
    public static final Tag.Identified<Block> INFINIBURN_AETHER = register("infiniburn_aether");

    private static Tag.Identified<Block> register(String id) {
        return ACCESSOR.get(id);
    }
}