package paperdomo101.aether_rewoven.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
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
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
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
import paperdomo101.aether_rewoven.block.BlueAercloudBlock;
import paperdomo101.aether_rewoven.block.EnchantedAetherGrassBlock;
import paperdomo101.aether_rewoven.block.UnrestrictedSoulFireBlock;
import paperdomo101.aether_rewoven.block.sapling.SkyrootSaplingGenerator;

public class AetherBlocks {

    //Blocks
    public static final Block UNRESTRICTED_SOUL_FIRE = new UnrestrictedSoulFireBlock(FabricBlockSettings.copy(Blocks.SOUL_FIRE).noCollision().breakInstantly().lightLevel((state) -> {return 10;}).sounds(BlockSoundGroup.WOOL));
    public static final Block AETHER_PORTAL = new AetherPortalBlock(FabricBlockSettings.of(Material.PORTAL).noCollision().ticksRandomly().strength(-1.0F).sounds(BlockSoundGroup.GLASS).lightLevel((state) -> {return 11;}));

    public static final Block AETHER_GRASS_BLOCK = new AetherGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).materialColor(MaterialColor.field_25706).breakByTool(FabricToolTags.SHOVELS).ticksRandomly().strength(0.2f, 0.2f).sounds(BlockSoundGroup.GRASS));
    public static final Block ENCHANTED_AETHER_GRASS_BLOCK = new EnchantedAetherGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).materialColor(MaterialColor.GOLD).breakByTool(FabricToolTags.SHOVELS).ticksRandomly().strength(0.2f, 0.2f).sounds(BlockSoundGroup.GRASS));
    public static final Block AETHER_DIRT = new Block(FabricBlockSettings.copyOf(Blocks.DIRT).materialColor(MaterialColor.CLAY).breakByTool(FabricToolTags.SHOVELS).strength(0.2f, 0.2f));

    public static final Block COLD_AERCLOUD = new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.WHITE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque());
    public static final Block GOLDEN_AERCLOUD = new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.GOLD).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque());
    public static final Block BLUE_AERCLOUD = new BlueAercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.LIGHT_BLUE).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque());
    public static final Block PINK_AERCLOUD = new AercloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.PINK).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).nonOpaque());
    public static final Block GRAY_ASHCLOUD = new AshcloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.GRAY).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).noCollision().nonOpaque(), StatusEffects.WEAKNESS);
    public static final Block BLACK_ASHCLOUD = new AshcloudBlock(FabricBlockSettings.of(Material.ICE, MaterialColor.BLACK).strength(0.2f, 0f).sounds(BlockSoundGroup.WOOL).noCollision().nonOpaque(), StatusEffects.WITHER);

    public static final Block QUICKSOIL = new Block(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f).slipperiness(1.1f));
    public static final Block QUICKSOIL_GLASS = new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(0.3f, 1.5f).slipperiness(1.1f));

    public static final Block SKYROOT_SAPLING = new AetherSaplingBlock(new SkyrootSaplingGenerator(), FabricBlockSettings.of(Material.LEAVES).strength(0.2F).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never));
    public static final Block SKYROOT_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never));
    public static final Block SKYROOT_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 10.0f));
    public static final Block STRIPPED_SKYROOT_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 10.0f));
    public static final Block SKYROOT_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 10.0f));
    public static final Block STRIPPED_SKYROOT_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 10.0f));
    public static final Block SKYROOT_PLANKS = new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_STAIRS = new AetherStairsBlock(SKYROOT_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_FENCE = new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_BUTTON = new AetherWoodButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_PRESSURE_PLATE = new AetherPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(0.5f, 15.0f));
    public static final Block SKYROOT_DOOR = new AetherDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_TRAPDOOR = new AetherTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    public static final Block SKYROOT_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF).materialColor(MaterialColor.GREEN_TERRACOTTA).strength(2.0f, 15.0f));
    
    // public static final Block BANEJO_SAPLING = register("banejo_sapling", new AetherSaplingBlock(new OakSaplingGenerator(), FabricBlockSettings.of(Material.LEAVES).strength(0.2F).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never));
    // public static final Block BANEJO_LEAVES = register("banejo_leaves", new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never));
    // public static final Block BANEJO_LOG = register("banejo_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).materialColor(MaterialColor.PINK).strength(2.0f, 10.0f));
    // public static final Block BANEJO_PLANKS = register("banejo_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).materialColor(MaterialColor.PINK).strength(2.0f, 15.0f));
    // public static final Block BANEJO_TILES = register("banejo_tiles", new Block(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).materialColor(MaterialColor.PINK).strength(3.0f, 5.0f));
    // public static final Block BANEJO_POT = register("banejo_pot", new BanejoPotBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).strength(1.8f, 3.0f));
   
    // public static final Block CRYSTAL_LOG = register("crystal_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).materialColor(MaterialColor.ICE).strength(2.0f, 10.0f).nonOpaque());
    // public static final Block CRYSTAL_DOOR = register("crystal_door", new AetherDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).materialColor(MaterialColor.ICE).strength(2.0f, 15.0f));
    
    public static final Block HOLYSTONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block HOLYSTONE_STAIRS = new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block HOLYSTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block HOLYSTONE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE_STAIRS = new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block HOLYSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block HOLYSTONE_BRICK_STAIRS = new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block HOLYSTONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block HOLYSTONE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE_BRICK_STAIRS = new AetherStairsBlock(HOLYSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block MOSSY_HOLYSTONE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    
    public static final Block ICESTONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).materialColor(MaterialColor.WHITE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.GLASS).strength(3.0f, 4.0f));
    
    public static final Block AMBROSIUM_ORE = new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE).materialColor(MaterialColor.YELLOW).breakByTool(FabricToolTags.PICKAXES).strength(0.7f, 4.0f));
    public static final Block AMBROSIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.YELLOW).lightLevel((state) -> {return 5;}).nonOpaque().requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final Block AMBROSIUM_TORCH = new AetherTorchBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().lightLevel((state) -> {return 10;}).sounds(BlockSoundGroup.WOOD), AetherParticles.AMBROSIUM_SHINE, false);
    public static final Block AMBROSIUM_WALL_TORCH = new AetherWallTorchBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().lightLevel((state) -> {return 10;}).sounds(BlockSoundGroup.WOOD).dropsLike(AMBROSIUM_TORCH), AetherParticles.AMBROSIUM_SHINE, false);
   
    public static final Block ZANITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).materialColor(MaterialColor.PURPLE).breakByTool(FabricToolTags.PICKAXES).strength(0.8f, 4.0f));
    public static final Block ZANITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.PURPLE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    // // public static final Block ZANITE_ANVIL = register("zanite_anvil", new AnvilBlock(FabricBlockSettings.copy(Blocks.ANVIL));
    
    public static final Block GRAVITITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).materialColor(MaterialColor.PINK).breakByTool(FabricToolTags.PICKAXES).strength(1.0f, 4.0f));
    public static final Block GRAVITITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.PINK).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
  
    public static final Block CARVED_STONE = new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6));
    public static final Block CARVED_STONE_STAIRS = new AetherStairsBlock(CARVED_STONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE_STAIRS).strength(1.5f, 6));
    public static final Block CARVED_STONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block CARVED_STONE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.PICKAXES).strength(0.5f, 4.0f));
    public static final Block WATCHFUL_CARVED_STONE = new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6));
    public static final Block SENTRY_STONE = new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6).lightLevel((state) -> {return 3;}).nonOpaque());

    // public static final Block ANGELIC_STONE = register("angelic_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6));
    // // public static final Block ANGELIC_STAIRS = register("angelic_stairs", new AetherStairsBlock(ANGELIC_STONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE_STAIRS).strength(1.5f, 6));
    // // public static final Block ANGELIC_SLAB = register("angelic_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB).strength(1.5f, 6));
    // // public static final Block ANGELIC_WALL = register("angelic_wall", new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL).strength(1.5f, 6));
    // public static final Block LUMINOUS_ANGELIC_STONE = register("luminous_angelic_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6).lightLevel((state) -> {return 3;}).nonOpaque());
    // // public static final Block LUMINOUS_ANGELIC_STAIRS = register("luminous_angelic_stairs", new AetherStairsBlock(LUMINOUS_ANGELIC_STONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE_STAIRS).strength(1.5f, 6).lightLevel((state) -> {return 3;}));
    // // public static final Block LUMINOUS_ANGELIC_SLAB = register("luminous_angelic_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB).strength(1.5f, 6).lightLevel((state) -> {return 3;}));
    // // public static final Block LUMINOUS_ANGELIC_WALL = register("luminous_angelic_wall", new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL).strength(1.5f, 6).lightLevel((state) -> {return 3;}));
    // public static final Block PEARL_PILLAR = register("pearl_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6));
    // public static final Block CHISELED_PEARL_PILLAR = register("chiseled_pearl_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6));

    // public static final Block HELLFIRE_STONE = register("hellfire_stone", new Block(FabricBlockSettings.copy(Blocks.STONE).strength(1.5f, 6));


    //Context
    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    //Registry
    // private static <B extends Block> B register(String name, B block, ItemGroup tab) {
    //     return register(name, block, new BlockItem(block, new Item.Settings().group(tab)));
    // }

    // private static <B extends Block> B register(String name, B block, BlockItem item) {
    //     register(name, block);
    //     if (item != null) {
    //         item.appendBlocks(Item.BLOCK_ITEMS, item);
    //         ITEMS.put(AetherRewoven.id(name), item);
    //     }
    //     return block;
    // }

    // private static <B extends Block> B register(String name, B block) {
    //     BLOCKS.put(AetherRewoven.id(name), block);
    //     return block;
    // }
    
    public static void init() {
        //Blocks without items
        Registry.register(Registry.BLOCK, AetherRewoven.id("aether_portal"), AETHER_PORTAL);
        Registry.register(Registry.BLOCK, AetherRewoven.id("soul_fire"), UNRESTRICTED_SOUL_FIRE);

        Registry.register(Registry.BLOCK, AetherRewoven.id("aether_grass_block"), AETHER_GRASS_BLOCK);
        Registry.register(Registry.BLOCK, AetherRewoven.id("enchanted_aether_grass_block"), ENCHANTED_AETHER_GRASS_BLOCK);
        Registry.register(Registry.BLOCK, AetherRewoven.id("aether_dirt"), AETHER_DIRT);

        Registry.register(Registry.BLOCK, AetherRewoven.id("cold_aercloud"), COLD_AERCLOUD);
        Registry.register(Registry.BLOCK, AetherRewoven.id("golden_aercloud"), GOLDEN_AERCLOUD);
        Registry.register(Registry.BLOCK, AetherRewoven.id("blue_aercloud"), BLUE_AERCLOUD);
        Registry.register(Registry.BLOCK, AetherRewoven.id("pink_aercloud"), PINK_AERCLOUD);
        Registry.register(Registry.BLOCK, AetherRewoven.id("gray_ashcloud"), GRAY_ASHCLOUD);
        Registry.register(Registry.BLOCK, AetherRewoven.id("black_ashcloud"), BLACK_ASHCLOUD);

        Registry.register(Registry.BLOCK, AetherRewoven.id("quicksoil"), QUICKSOIL);
        Registry.register(Registry.BLOCK, AetherRewoven.id("quicksoil_glass"), QUICKSOIL_GLASS);

        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_sapling"), SKYROOT_SAPLING);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_leaves"), SKYROOT_LEAVES);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_log"), SKYROOT_LOG);
        Registry.register(Registry.BLOCK, AetherRewoven.id("stripped_skyroot_log"), STRIPPED_SKYROOT_LOG);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_wood"), SKYROOT_WOOD);
        Registry.register(Registry.BLOCK, AetherRewoven.id("stripped_skyroot_wood"), STRIPPED_SKYROOT_WOOD);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_planks"), SKYROOT_PLANKS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_stairs"), SKYROOT_STAIRS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_slab"), SKYROOT_SLAB);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_fence"), SKYROOT_FENCE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_fence_gate"), SKYROOT_FENCE_GATE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_button"), SKYROOT_BUTTON);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_pressure_plate"), SKYROOT_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_door"), SKYROOT_DOOR);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_trapdoor"), SKYROOT_TRAPDOOR);
        Registry.register(Registry.BLOCK, AetherRewoven.id("skyroot_bookshelf"), SKYROOT_BOOKSHELF);

        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone"), HOLYSTONE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone_slab"), HOLYSTONE_SLAB);
        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone_stairs"), HOLYSTONE_STAIRS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone_wall"), HOLYSTONE_WALL);
        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone_bricks"), HOLYSTONE_BRICKS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone_brick_slab"), HOLYSTONE_BRICK_SLAB);
        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone_brick_stairs"), HOLYSTONE_BRICK_STAIRS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("holystone_brick_wall"), HOLYSTONE_BRICK_WALL);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone"), MOSSY_HOLYSTONE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone_slab"), MOSSY_HOLYSTONE_SLAB);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone_stairs"), MOSSY_HOLYSTONE_STAIRS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone_wall"), MOSSY_HOLYSTONE_WALL);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone_bricks"), MOSSY_HOLYSTONE_BRICKS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone_brick_slab"), MOSSY_HOLYSTONE_BRICK_SLAB);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone_brick_stairs"), MOSSY_HOLYSTONE_BRICK_STAIRS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("mossy_holystone_brick_wall"), MOSSY_HOLYSTONE_BRICK_WALL);

        Registry.register(Registry.BLOCK, AetherRewoven.id("icestone"), ICESTONE);

        Registry.register(Registry.BLOCK, AetherRewoven.id("ambrosium_ore"), AMBROSIUM_ORE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("ambrosium_block"), AMBROSIUM_BLOCK);
        Registry.register(Registry.BLOCK, AetherRewoven.id("ambrosium_torch"), AMBROSIUM_TORCH);
        Registry.register(Registry.BLOCK, AetherRewoven.id("ambrosium_wall_torch"), AMBROSIUM_WALL_TORCH);

        Registry.register(Registry.BLOCK, AetherRewoven.id("zanite_ore"), ZANITE_ORE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("zanite_block"), ZANITE_BLOCK);

        Registry.register(Registry.BLOCK, AetherRewoven.id("gravitite_ore"), GRAVITITE_ORE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("gravitite_block"), GRAVITITE_BLOCK);

        Registry.register(Registry.BLOCK, AetherRewoven.id("carved_stone"), CARVED_STONE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("carved_stone_slab"), CARVED_STONE_SLAB);
        Registry.register(Registry.BLOCK, AetherRewoven.id("carved_stone_stairs"), CARVED_STONE_STAIRS);
        Registry.register(Registry.BLOCK, AetherRewoven.id("carved_stone_wall"), CARVED_STONE_WALL);
        Registry.register(Registry.BLOCK, AetherRewoven.id("watchful_carved_stone"), WATCHFUL_CARVED_STONE);
        Registry.register(Registry.BLOCK, AetherRewoven.id("sentry_stone"), SENTRY_STONE);
        
    }
}