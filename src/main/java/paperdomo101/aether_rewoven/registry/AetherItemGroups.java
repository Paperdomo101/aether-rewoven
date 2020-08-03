package paperdomo101.aether_rewoven.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import paperdomo101.aether_rewoven.AetherRewoven;

public class AetherItemGroups {
	public static final ItemGroup AETHER_BLOCKS = FabricItemGroupBuilder.build(AetherRewoven.id("aether_blocks"), () -> new ItemStack(AetherBlocks.AETHER_GRASS_BLOCK));
	public static final ItemGroup AETHER_TRANSPORTATION = FabricItemGroupBuilder.build(AetherRewoven.id("aether_transportation"), () -> new ItemStack(AetherItems.COLD_PARACHUTE));
	public static final ItemGroup AETHER_MISC = FabricItemGroupBuilder.build(AetherRewoven.id("aether_misc"), () -> new ItemStack(AetherItems.BRONZE_KEY));
	public static final ItemGroup AETHER_FOOD = FabricItemGroupBuilder.build(AetherRewoven.id("aether_food"), () -> new ItemStack(AetherItems.BLUEBERRY));
	public static final ItemGroup AETHER_TOOLS = FabricItemGroupBuilder.build(AetherRewoven.id("aether_tools"), () -> new ItemStack(AetherItems.ZANITE_AXE));
	public static final ItemGroup AETHER_COMBAT = FabricItemGroupBuilder.build(AetherRewoven.id("aether_combat"), () -> new ItemStack(AetherItems.GRAVITITE_SWORD));
	public static final ItemGroup AETHER_MATERIALS = FabricItemGroupBuilder.build(AetherRewoven.id("aether_materials"), () -> new ItemStack(AetherItems.AMBROSIUM_SHARD));
    
}