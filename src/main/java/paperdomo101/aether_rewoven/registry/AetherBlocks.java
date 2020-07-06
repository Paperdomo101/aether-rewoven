package paperdomo101.aether_rewoven.registry;

import java.util.HashMap;
import java.util.Map;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.block.AercloudBlock;
import paperdomo101.aether_rewoven.block.AetherGrassBlock;
import paperdomo101.aether_rewoven.block.AetherPortalBlock;
import paperdomo101.aether_rewoven.block.AetherTorchBlock;
import paperdomo101.aether_rewoven.block.AetherWallTorchBlock;
import paperdomo101.aether_rewoven.block.BlueAercloudBlock;

public class AetherBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    //Blocks
    public static final Block AETHER_PORTAL = new AetherPortalBlock(FabricBlockSettings.of(Material.PORTAL).noCollision().ticksRandomly().strength(-1.0F).sounds(BlockSoundGroup.GLASS).lightLevel((state) -> {return 11;}));

    public static final Block AETHER_GRASS_BLOCK = register("aether_grass_block", new AetherGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).materialColor(MaterialColor.field_25706).breakByTool(FabricToolTags.SHOVELS).ticksRandomly().strength(0.2f, 0.2f).sounds(BlockSoundGroup.GRASS)), AetherRewoven.AETHER_BLOCKS);
    public static final Block AETHER_DIRT = register("aether_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).materialColor(MaterialColor.CLAY).breakByTool(FabricToolTags.SHOVELS).strength(0.2f, 0.2f)), AetherRewoven.AETHER_BLOCKS);
    
    public static final Block HOLYSTONE = register("holystone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4)), AetherRewoven.AETHER_BLOCKS);

    public static final Block COLD_AERCLOUD = register("cold_aercloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.WHITE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block GOLDEN_AERCLOUD = register("golden_aercloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.GOLD).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block BLUE_AERCLOUD = register("blue_aercloud", new BlueAercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.LIGHT_BLUE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block PINK_AERCLOUD = register("pink_aercloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.PINK).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block GRAY_ASHCLOUD = register("gray_ashcloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.GRAY).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block BLACK_ASHCLOUD = register("black_ashcloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.BLACK).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);

    public static final Block QUICKSOIL = register("quicksoil", new Block(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f).slipperiness(1.1f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block QUICKSOIL_GLASS = register("quicksoil_glass", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(0.3f, 1.5f).slipperiness(1.1f)), AetherRewoven.AETHER_BLOCKS);

    public static final Block SKYROOT_LEAVES = register("skyroot_leaves", new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_LOG = register("skyroot_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 10.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_PLANKS = register("skyroot_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)), AetherRewoven.AETHER_BLOCKS);

    public static final Block AMBROSIUM_TORCH = register("ambrosium_torch", new AetherTorchBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().lightLevel((state) -> {return 9;}).sounds(BlockSoundGroup.WOOD), AetherParticles.AMBROSIUM_DUST, false), AetherRewoven.AETHER_BLOCKS);
    public static final Block AMBROSIUM_WALL_TORCH = register("ambrosium_wall_torch", new AetherWallTorchBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().lightLevel((state) -> {return 9;}).sounds(BlockSoundGroup.WOOD).dropsLike(AMBROSIUM_TORCH), AetherParticles.AMBROSIUM_DUST, false));
    public static final Block AMBROSIUM_BLOCK = register("ambrosium_block", new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.YELLOW).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)), AetherRewoven.AETHER_BLOCKS);

    public static final Block CARVED_STONE = register("carved_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);


    //Context
    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

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
        //Blocks without items
        Registry.register(Registry.BLOCK, AetherRewoven.id("aether_portal"), AETHER_PORTAL);

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }
}