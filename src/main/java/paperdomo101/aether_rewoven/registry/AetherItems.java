package paperdomo101.aether_rewoven.registry;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.item.AmbrosiumShardItem;

public class AetherItems {
    
    public static final Item SKYROOT_STICK = register("skyroot_stick", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_PARACHUTE = register("golden_parachute", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item BLUE_SWET_BALL = register("blue_swet_ball", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item BLUE_GUMMY_SWET = register("blue_gummy_swet", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_GUMMY_SWET = register("golden_gummy_swet", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item DIVINE_LEATHER = register("divine_leather", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item AMBROSIUM_SHARD = register("ambrosium_shard", new AmbrosiumShardItem(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item ZANITE_GEMSTONE = register("zanite_gemstone", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    
    public static void init() {
    
    }

    protected static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, AetherRewoven.id(name), item);
	}
}