package paperdomo101.aether_rewoven.registry;

import java.util.HashMap;
import java.util.Map;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
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
import paperdomo101.aether_rewoven.block.AetherDoorBlock;
import paperdomo101.aether_rewoven.block.AetherGrassBlock;
import paperdomo101.aether_rewoven.block.AetherPortalBlock;
import paperdomo101.aether_rewoven.block.AetherPressurePlateBlock;
import paperdomo101.aether_rewoven.block.AetherSaplingBlock;
import paperdomo101.aether_rewoven.block.AetherStairsBlock;
import paperdomo101.aether_rewoven.block.AetherTorchBlock;
import paperdomo101.aether_rewoven.block.AetherTrapdoorBlock;
import paperdomo101.aether_rewoven.block.AetherWallTorchBlock;
import paperdomo101.aether_rewoven.block.AetherWoodButtonBlock;
import paperdomo101.aether_rewoven.block.AshcloudBlock;
import paperdomo101.aether_rewoven.block.BanejoPotBlock;
import paperdomo101.aether_rewoven.block.BlueAercloudBlock;
import paperdomo101.aether_rewoven.block.EnchantedAetherGrassBlock;
import paperdomo101.aether_rewoven.block.UnrestrictedSoulFireBlock;

public class AetherBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    //Blocks
    public static final Block UNRESTRICTED_SOUL_FIRE = new UnrestrictedSoulFireBlock(FabricBlockSettings.copy(Blocks.SOUL_FIRE).noCollision().breakInstantly().lightLevel((state) -> {return 10;}).sounds(BlockSoundGroup.WOOL));
    public static final Block AETHER_PORTAL = new AetherPortalBlock(FabricBlockSettings.of(Material.PORTAL).noCollision().ticksRandomly().strength(-1.0F).sounds(BlockSoundGroup.GLASS).lightLevel((state) -> {return 11;}));

    public static final Block AETHER_GRASS_BLOCK = register("aether_grass_block", new AetherGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).materialColor(MaterialColor.field_25706).breakByTool(FabricToolTags.SHOVELS).ticksRandomly().strength(0.2f, 0.2f).sounds(BlockSoundGroup.GRASS)), AetherRewoven.AETHER_BLOCKS);
    public static final Block ENCHANTED_AETHER_GRASS_BLOCK = register("enchanted_aether_grass_block", new EnchantedAetherGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).materialColor(MaterialColor.GOLD).breakByTool(FabricToolTags.SHOVELS).ticksRandomly().strength(0.2f, 0.2f).sounds(BlockSoundGroup.GRASS)), AetherRewoven.AETHER_BLOCKS);
    public static final Block AETHER_DIRT = register("aether_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).materialColor(MaterialColor.CLAY).breakByTool(FabricToolTags.SHOVELS).strength(0.2f, 0.2f)), AetherRewoven.AETHER_BLOCKS);

    public static final Block COLD_AERCLOUD = register("cold_aercloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.WHITE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block GOLDEN_AERCLOUD = register("golden_aercloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.GOLD).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block BLUE_AERCLOUD = register("blue_aercloud", new BlueAercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.LIGHT_BLUE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block PINK_AERCLOUD = register("pink_aercloud", new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.PINK).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block GRAY_ASHCLOUD = register("gray_ashcloud", new AshcloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.GRAY).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).noCollision().nonOpaque(), StatusEffects.WEAKNESS), AetherRewoven.AETHER_BLOCKS);
    public static final Block BLACK_ASHCLOUD = register("black_ashcloud", new AshcloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.BLACK).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).noCollision().nonOpaque(), StatusEffects.WITHER), AetherRewoven.AETHER_BLOCKS);

    public static final Block QUICKSOIL = register("quicksoil", new Block(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f).slipperiness(1.1f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block QUICKSOIL_GLASS = register("quicksoil_glass", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(0.3f, 1.5f).slipperiness(1.1f)), AetherRewoven.AETHER_BLOCKS);

    public static final Block SKYROOT_SAPLING = register("skyroot_sapling", new AetherSaplingBlock(new OakSaplingGenerator(), FabricBlockSettings.of(Material.LEAVES).strength(0.2F).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_LEAVES = register("skyroot_leaves", new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_LOG = register("skyroot_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 10.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_WOOD = register("skyroot_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 10.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_PLANKS = register("skyroot_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_STAIRS = register("skyroot_stairs", new AetherStairsBlock(SKYROOT_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_SLAB = register("skyroot_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_FENCE = register("skyroot_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_FENCE_GATE = register("skyroot_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_BUTTON = register("skyroot_button", new AetherWoodButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_PRESSURE_PLATE = register("skyroot_pressure_plate", new AetherPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(0.5f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_DOOR = register("skyroot_door", new AetherDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_TRAPDOOR = register("skyroot_trapdoor", new AetherTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    public static final Block SKYROOT_BOOKSHELF = register("skyroot_bookshelf", new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f)), AetherRewoven.AETHER_BLOCKS);
    
    public static final Block BANEJO_SAPLING = register("banejo_sapling", new AetherSaplingBlock(new OakSaplingGenerator(), FabricBlockSettings.of(Material.LEAVES).strength(0.2F).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never)), AetherRewoven.AETHER_BLOCKS);
    public static final Block BANEJO_LEAVES = register("banejo_leaves", new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never)), AetherRewoven.AETHER_BLOCKS);
    public static final Block BANEJO_LOG = register("banejo_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).materialColor(MaterialColor.PINK).strength(2.0f, 10.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block BANEJO_PLANKS = register("banejo_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).materialColor(MaterialColor.PINK).strength(2.0f, 15.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block BANEJO_TILES = register("banejo_tiles", new Block(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).materialColor(MaterialColor.PINK).strength(3.0f, 5.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block BANEJO_POT = register("banejo_pot", new BanejoPotBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).strength(1.8f, 3.0f)), AetherRewoven.AETHER_BLOCKS);
   
    public static final Block CRYSTAL_LOG = register("crystal_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).materialColor(MaterialColor.ICE).strength(2.0f, 10.0f).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    public static final Block CRYSTAL_DOOR = register("crystal_door", new AetherDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).materialColor(MaterialColor.ICE).strength(2.0f, 15.0f)),AetherRewoven.AETHER_BLOCKS);
    
    public static final Block HOLYSTONE = register("holystone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE_STAIRS = register("holystone_stairs", new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE_SLAB = register("holystone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE_WALL = register("holystone_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE = register("mossy_holystone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE_STAIRS = register("mossy_holystone_stairs", new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE_SLAB = register("mossy_holystone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE_WALL = register("mossy_holystone_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE_BRICKS = register("holystone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE_BRICK_STAIRS = register("holystone_brick_stairs", new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE_BRICK_SLAB = register("holystone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block HOLYSTONE_BRICK_WALL = register("holystone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE_BRICKS = register("mossy_holystone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE_BRICK_STAIRS = register("mossy_holystone_brick_stairs", new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE_BRICK_SLAB = register("mossy_holystone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block MOSSY_HOLYSTONE_BRICK_WALL = register("mossy_holystone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    
    public static final Block ICESTONE = register("icestone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.WHITE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.GLASS).strength(3.0f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    
    public static final Block AMBROSIUM_ORE = register("ambrosium_ore", new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE).materialColor(MaterialColor.YELLOW).breakByTool(FabricToolTags.PICKAXES).strength(0.7f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block AMBROSIUM_BLOCK = register("ambrosium_block", new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.YELLOW).lightLevel((state) -> {return 5;}).nonOpaque().requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)), AetherRewoven.AETHER_BLOCKS);
    public static final Block AMBROSIUM_TORCH = new AetherTorchBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().lightLevel((state) -> {return 10;}).sounds(BlockSoundGroup.WOOD), AetherParticles.AMBROSIUM_SHINE, false);
    public static final Block AMBROSIUM_WALL_TORCH = new AetherWallTorchBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().lightLevel((state) -> {return 10;}).sounds(BlockSoundGroup.WOOD).dropsLike(AMBROSIUM_TORCH), AetherParticles.AMBROSIUM_SHINE, false);
   
    public static final Block ZANITE_ORE = register("zanite_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).materialColor(MaterialColor.PURPLE).breakByTool(FabricToolTags.PICKAXES).strength(0.8f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block ZANITE_BLOCK = register("zanite_block", new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.PURPLE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)), AetherRewoven.AETHER_BLOCKS);
    // public static final Block ZANITE_ANVIL = register("zanite_anvil", new AnvilBlock(FabricBlockSettings.copy(Blocks.ANVIL)), AetherRewoven.AETHER_BLOCKS);
    
    public static final Block GRAVITITE_ORE = register("gravitite_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).materialColor(MaterialColor.PINK).breakByTool(FabricToolTags.PICKAXES).strength(1.0f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block GRAVITITE_BLOCK = register("gravitite_block", new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.PINK).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)), AetherRewoven.AETHER_BLOCKS);
  
    public static final Block CARVED_STONE = register("carved_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    public static final Block CARVED_STONE_STAIRS = register("carved_stone_stairs", new AetherStairsBlock(CARVED_STONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE_STAIRS).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    public static final Block CARVED_STONE_SLAB = register("carved_stone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block CARVED_STONE_WALL = register("carved_stone_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f)), AetherRewoven.AETHER_BLOCKS);
    public static final Block WATCHFUL_CARVED_STONE = register("watchful_carved_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    public static final Block SENTRY_STONE = register("sentry_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6).lightLevel((state) -> {return 3;}).nonOpaque()), AetherRewoven.AETHER_BLOCKS);

    public static final Block ANGELIC_STONE = register("angelic_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    // public static final Block ANGELIC_STAIRS = register("angelic_stairs", new AetherStairsBlock(ANGELIC_STONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE_STAIRS).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    // public static final Block ANGELIC_SLAB = register("angelic_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    // public static final Block ANGELIC_WALL = register("angelic_wall", new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    public static final Block LUMINOUS_ANGELIC_STONE = register("luminous_angelic_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6).lightLevel((state) -> {return 3;}).nonOpaque()), AetherRewoven.AETHER_BLOCKS);
    // public static final Block LUMINOUS_ANGELIC_STAIRS = register("luminous_angelic_stairs", new AetherStairsBlock(LUMINOUS_ANGELIC_STONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE_STAIRS).strength(1.5f, 6).lightLevel((state) -> {return 3;})), AetherRewoven.AETHER_BLOCKS);
    // public static final Block LUMINOUS_ANGELIC_SLAB = register("luminous_angelic_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB).strength(1.5f, 6).lightLevel((state) -> {return 3;})), AetherRewoven.AETHER_BLOCKS);
    // public static final Block LUMINOUS_ANGELIC_WALL = register("luminous_angelic_wall", new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL).strength(1.5f, 6).lightLevel((state) -> {return 3;})), AetherRewoven.AETHER_BLOCKS);
    public static final Block PEARL_PILLAR = register("pearl_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);
    public static final Block CHISELED_PEARL_PILLAR = register("chiseled_pearl_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);

    public static final Block HELLFIRE_STONE = register("hellfire_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6)), AetherRewoven.AETHER_BLOCKS);


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
        Registry.register(Registry.BLOCK, AetherRewoven.id("soul_fire"), UNRESTRICTED_SOUL_FIRE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("ambrosium_torch"), AMBROSIUM_TORCH);
        Registry.register(Registry.BLOCK, AetherRewoven.id("ambrosium_wall_torch"), AMBROSIUM_WALL_TORCH);

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }
}