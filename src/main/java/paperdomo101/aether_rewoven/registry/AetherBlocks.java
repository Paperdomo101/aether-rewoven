package paperdomo101.aether_rewoven.registry;

import java.util.HashMap;
import java.util.Map;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.block.AercloudBlock;
import paperdomo101.aether_rewoven.block.AetherGrassBlock;
import paperdomo101.aether_rewoven.block.BlueAercloudBlock;

public class AetherBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    //Blocks

    public static final Block AETHER_GRASS_BLOCK = register("aether_grass_block", new AetherGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).materialColor(MaterialColor.field_25706).breakByTool(FabricToolTags.SHOVELS).ticksRandomly().strength(0.2f, 0.2f).sounds(BlockSoundGroup.GRASS)), AetherRewoven.AETHER_BLOCKS);
    public static final Block AETHER_DIRT = register("aether_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).materialColor(MaterialColor.CLAY).breakByTool(FabricToolTags.SHOVELS).strength(0.2f, 0.2f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE = register("holystone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4)), AetherRewoven.AETHER_BLOCKS);
    public static final Block COLD_AERCLOUD = register("cold_aercloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.WHITE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block BLUE_AERCLOUD = register("blue_aercloud", new BlueAercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.LIGHT_BLUE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    
    public static final Block CARVED_STONE = register("carved_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);


    //Registry

    private static <B extends Block> B register(String name, B block, ItemGroup tab) {
        return register(name, block, new BlockItem(block, new Item.Settings().group(tab)));
    }

    private static <B extends Block> B register(String name, B block, BlockItem item) {
        register(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(AetherRewoven.id(name), item);
        }
        return block;
    }

    private static <B extends Block> B register(String name, B block) {
        BLOCKS.put(AetherRewoven.id(name), block);
        return block;
    }
    
    public static void init() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }
}