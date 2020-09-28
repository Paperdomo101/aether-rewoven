package paperdomo101.aether_rewoven.registry;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.item.AetherArmorItem;
import paperdomo101.aether_rewoven.item.AetherAxeItem;
import paperdomo101.aether_rewoven.item.AetherDebugItem;
import paperdomo101.aether_rewoven.item.AetherDebugItem.DebugItemType;
import paperdomo101.aether_rewoven.item.AetherMusicDiscItem;
import paperdomo101.aether_rewoven.item.AetherPickaxeItem;
import paperdomo101.aether_rewoven.item.AetherToolMaterials;
import paperdomo101.aether_rewoven.item.AmbrosiumShardItem;
import paperdomo101.aether_rewoven.item.FlintAndSoulsteelItem;

public class AetherItems {
    
    //Materials
    public static final Item SKYROOT_STICK = register("skyroot_stick", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item AECHOR_PETAL = register("aechor_petal", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item BLUE_SWET_BALL = register("blue_swet_ball", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item GOLDEN_SWET_BALL = register("golden_swet_ball", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item DIVINE_LEATHER = register("divine_leather", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item GOLDEN_AMBER = register("golden_amber", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item GOLDEN_FEATHER = register("golden_feather", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item AMBROSIUM_SHARD = register("ambrosium_shard", new AmbrosiumShardItem(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item ZANITE_GEMSTONE = register("zanite_gemstone", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item GRAVITITE = register("gravitite", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item ENCHANTED_GRAVITITE = register("enchanted_gravitite", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item BISMUTH = register("bismuth", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));
    public static final Item CRUDE_MELD = register("crude_meld", new AmbrosiumShardItem(new Item.Settings().group(AetherItemGroups.AETHER_MATERIALS)));

    //Transportation
    public static final Item COLD_PARACHUTE = register("cold_parachute", new Item(new Item.Settings().group(AetherItemGroups.AETHER_TRANSPORTATION)));
    public static final Item GOLDEN_PARACHUTE = register("golden_parachute", new Item(new Item.Settings().group(AetherItemGroups.AETHER_TRANSPORTATION)));

    //Tools
    public static final Item FLINT_AND_SOULSTEEL = register("flint_and_soulsteel", new FlintAndSoulsteelItem(new Item.Settings().maxCount(1).maxDamage(128).group(AetherItemGroups.AETHER_TOOLS).fireproof()));
    public static final Item SKYROOT_PICKAXE = register("skyroot_pickaxe", new AetherPickaxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item SKYROOT_AXE = register("skyroot_axe", new AetherAxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item SKYROOT_SHOVEL = register("skyroot_shovel", new ShovelItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item HOLYSTONE_PICKAXE = register("holystone_pickaxe", new AetherPickaxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item HOLYSTONE_AXE = register("holystone_axe", new AetherAxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item HOLYSTONE_SHOVEL = register("holystone_shovel", new ShovelItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item ZANITE_PICKAXE = register("zanite_pickaxe", new AetherPickaxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item ZANITE_AXE = register("zanite_axe", new AetherAxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item ZANITE_SHOVEL = register("zanite_shovel", new ShovelItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item GRAVITITE_PICKAXE = register("gravitite_pickaxe", new AetherPickaxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item GRAVITITE_AXE = register("gravitite_axe", new AetherAxeItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    public static final Item GRAVITITE_SHOVEL = register("gravitite_shovel", new ShovelItem(AetherToolMaterials.SKYROOT, 1, -2.8f, new Item.Settings().group(AetherItemGroups.AETHER_TOOLS)));
    
    //WEAPONS
    public static final Item SKYROOT_SWORD = register("skyroot_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherItemGroups.AETHER_COMBAT)));
    public static final Item HOLYSTONE_SWORD = register("holystone_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherItemGroups.AETHER_COMBAT)));
    public static final Item ZANITE_SWORD = register("zanite_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherItemGroups.AETHER_COMBAT)));
    public static final Item GRAVITITE_SWORD = register("gravitite_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherItemGroups.AETHER_COMBAT)));

    //Armor
    public static final Item PHOENIX_HELMET = register("phoenix_helmet", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(AetherItemGroups.AETHER_COMBAT)));
    public static final Item PHOENIX_CHESTPLATE = register("phoenix_chestplate", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(AetherItemGroups.AETHER_COMBAT)));
    public static final Item PHOENIX_LEGGINGS = register("phoenix_leggings", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(AetherItemGroups.AETHER_COMBAT)));
    public static final Item PHOENIX_BOOTS = register("phoenix_boots", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.FEET, new Item.Settings().fireproof().group(AetherItemGroups.AETHER_COMBAT)));

    //Food
    public static final Item BLUEBERRY = register("blueberry", new Item(new Item.Settings().food(FoodComponents.SWEET_BERRIES).group(AetherItemGroups.AETHER_FOOD)));
    public static final Item BLUE_GUMMY_SWET = register("blue_gummy_swet", new Item(new Item.Settings().food(FoodComponents.BREAD).group(AetherItemGroups.AETHER_FOOD)));
    public static final Item GOLDEN_GUMMY_SWET = register("golden_gummy_swet", new Item(new Item.Settings().food(FoodComponents.BREAD).group(AetherItemGroups.AETHER_FOOD)));
    public static final Item CANDY_CANE = register("candy_cane", new Item(new Item.Settings().food(FoodComponents.APPLE).group(AetherItemGroups.AETHER_FOOD)));
    public static final Item GINGERBREAD_MAN = register("gingerbread_man", new Item(new Item.Settings().food(FoodComponents.COOKIE).group(AetherItemGroups.AETHER_FOOD)));
    public static final Item WHITE_APPLE = register("white_apple", new Item(new Item.Settings().food(FoodComponents.APPLE).group(AetherItemGroups.AETHER_FOOD)));

    //Miscellaneous
    public static final Item SKYROOT_BUCKET = register("skyroot_bucket", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item SKYROOT_WATER_BUCKET = register("skyroot_water_bucket", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item SKYROOT_SPRING_WATER_BUCKET = register("skyroot_spring_water_bucket", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item SKYROOT_POISON_BUCKET = register("skyroot_poison_bucket", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item SKYROOT_MILK_BUCKET = register("skyroot_milk_bucket", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item TRAVEL_LOG = register("travel_log", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item BRONZE_KEY = register("bronze_key", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item SILVER_KEY = register("silver_key", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item GOLDEN_KEY = register("golden_key", new Item(new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    // public static final Item BLUE_SWET_SPAWN_EGG = register("blue_swet_spawn_egg", new SpawnEggItem(AetherEntities.BLUE_SWET, 0x4C8DC4, 0x80B7F2, new Item.Settings().group(AetherItemGroups.AETHER_ITEMS)));
    public static final Item PHYG_SPAWN_EGG = register("phyg_spawn_egg", new SpawnEggItem(AetherEntities.PHYG, 0xf6b5bd, 0xeeda6a, new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item ZEPHYR_SPAWN_EGG = register("zephyr_spawn_egg", new SpawnEggItem(AetherEntities.ZEPHYR, 0xf2f0e6, 0x8eb1b9, new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item TEMPEST_SPAWN_EGG = register("tempest_spawn_egg", new SpawnEggItem(AetherEntities.TEMPEST, 0x262c34, 0x97ad96, new Item.Settings().group(AetherItemGroups.AETHER_MISC)));
    public static final Item MUSIC_DISC_AETHERTUNE = register("music_disc_aethertune", new AetherMusicDiscItem(14, AetherSounds.MUSIC_DISC_AETHERTUNE, (new Item.Settings()).maxCount(1).group(AetherItemGroups.AETHER_MISC).rarity(Rarity.RARE)));
    public static final Item MUSIC_DISC_FLIGHT = register("music_disc_flight", new AetherMusicDiscItem(15, AetherSounds.MUSIC_DISC_FLIGHT, (new Item.Settings()).maxCount(1).group(AetherItemGroups.AETHER_MISC).rarity(Rarity.RARE)));

    //Debug
    public static final Item DEBUG_PORTAL = register("debug_portal", new AetherDebugItem(new Item.Settings().group(AetherItemGroups.AETHER_MISC), DebugItemType.portal));

    //BlockItems
    public static final Item AETHER_GRASS_BLOCK = register("aether_grass_block", new BlockItem(AetherBlocks.AETHER_GRASS_BLOCK, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item ENCHANTED_AETHER_GRASS_BLOCK = register("enchanted_aether_grass_block", new BlockItem(AetherBlocks.ENCHANTED_AETHER_GRASS_BLOCK, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item AETHER_DIRT = register("aether_dirt", new BlockItem(AetherBlocks.AETHER_DIRT, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));

    public static final Item COLD_AERCLOUD = register("cold_aercloud", new BlockItem(AetherBlocks.COLD_AERCLOUD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item GOLDEN_AERCLOUD = register("golden_aercloud", new BlockItem(AetherBlocks.GOLDEN_AERCLOUD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item BLUE_AERCLOUD = register("blue_aercloud", new BlockItem(AetherBlocks.BLUE_AERCLOUD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item PINK_AERCLOUD = register("pink_aercloud", new BlockItem(AetherBlocks.PINK_AERCLOUD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item GRAY_ASHCLOUD = register("gray_ashcloud", new BlockItem(AetherBlocks.GRAY_ASHCLOUD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item BLACK_ASHCLOUD = register("black_ashcloud", new BlockItem(AetherBlocks.BLACK_ASHCLOUD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    
    public static final Item QUICKSOIL = register("quicksoil", new BlockItem(AetherBlocks.QUICKSOIL, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item QUICKSOIL_GLASS = register("quicksoil_glass", new BlockItem(AetherBlocks.QUICKSOIL_GLASS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    
    public static final Item AMBROSIUM_TORCH = register("ambrosium_torch", (BlockItem)(new WallStandingBlockItem(AetherBlocks.AMBROSIUM_TORCH, AetherBlocks.AMBROSIUM_WALL_TORCH, (new Item.Settings()).group(AetherItemGroups.AETHER_BLOCKS))));

    public static final Item SKYROOT_SAPLING = register("skyroot_sapling", new BlockItem(AetherBlocks.SKYROOT_SAPLING, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_LEAVES = register("skyroot_leaves", new BlockItem(AetherBlocks.SKYROOT_LEAVES, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_LOG = register("skyroot_log", new BlockItem(AetherBlocks.SKYROOT_LOG, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_WOOD = register("skyroot_wood", new BlockItem(AetherBlocks.SKYROOT_WOOD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item STRIPPED_SKYROOT_LOG = register("stripped_skyroot_log", new BlockItem(AetherBlocks.STRIPPED_SKYROOT_LOG, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item STRIPPED_SKYROOT_WOOD = register("stripped_skyroot_wood", new BlockItem(AetherBlocks.STRIPPED_SKYROOT_WOOD, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_PLANKS = register("skyroot_planks", new BlockItem(AetherBlocks.SKYROOT_PLANKS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_STAIRS = register("skyroot_stairs", new BlockItem(AetherBlocks.SKYROOT_STAIRS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_SLAB = register("skyroot_slab", new BlockItem(AetherBlocks.SKYROOT_SLAB, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_FENCE = register("skyroot_fence", new BlockItem(AetherBlocks.SKYROOT_FENCE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_FENCE_GATE = register("skyroot_fence_gate", new BlockItem(AetherBlocks.SKYROOT_FENCE_GATE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_BUTTON = register("skyroot_button", new BlockItem(AetherBlocks.SKYROOT_BUTTON, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_PRESSURE_PLATE = register("skyroot_pressure_plate", new BlockItem(AetherBlocks.SKYROOT_PRESSURE_PLATE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_DOOR = register("skyroot_door", new BlockItem(AetherBlocks.SKYROOT_DOOR, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_TRAPDOOR = register("skyroot_trapdoor", new BlockItem(AetherBlocks.SKYROOT_TRAPDOOR, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_BOOKSHELF = register("skyroot_bookshelf", new BlockItem(AetherBlocks.SKYROOT_BOOKSHELF, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SKYROOT_CRAFTING_TABLE = register("skyroot_crafting_table", new BlockItem(AetherBlocks.SKYROOT_CRAFTING_TABLE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));

    public static final Item HOLYSTONE = register("holystone", new BlockItem(AetherBlocks.HOLYSTONE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item HOLYSTONE_SLAB = register("holystone_slab", new BlockItem(AetherBlocks.HOLYSTONE_SLAB, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item HOLYSTONE_STAIRS = register("holystone_stairs", new BlockItem(AetherBlocks.HOLYSTONE_STAIRS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item HOLYSTONE_WALL = register("holystone_wall", new BlockItem(AetherBlocks.HOLYSTONE_WALL, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item HOLYSTONE_BRICKS = register("holystone_bricks", new BlockItem(AetherBlocks.HOLYSTONE_BRICKS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item HOLYSTONE_BRICK_SLAB = register("holystone_brick_slab", new BlockItem(AetherBlocks.HOLYSTONE_BRICK_SLAB, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item HOLYSTONE_BRICK_STAIRS = register("holystone_brick_stairs", new BlockItem(AetherBlocks.HOLYSTONE_BRICK_STAIRS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item HOLYSTONE_BRICK_WALL = register("holystone_brick_wall", new BlockItem(AetherBlocks.HOLYSTONE_BRICK_WALL, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE = register("mossy_holystone", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE_SLAB = register("mossy_holystone_slab", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE_SLAB, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE_STAIRS = register("mossy_holystone_stairs", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE_STAIRS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE_WALL = register("mossy_holystone_wall", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE_WALL, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE_BRICKS = register("mossy_holystone_bricks", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE_BRICKS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE_BRICK_SLAB = register("mossy_holystone_brick_slab", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE_BRICK_SLAB, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE_BRICK_STAIRS = register("mossy_holystone_brick_stairs", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE_BRICK_STAIRS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item MOSSY_HOLYSTONE_BRICK_WALL = register("mossy_holystone_brick_wall", new BlockItem(AetherBlocks.MOSSY_HOLYSTONE_BRICK_WALL, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    
    public static final Item ICESTONE = register("icestone", new BlockItem(AetherBlocks.ICESTONE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));

    public static final Item CARVED_STONE = register("carved_stone", new BlockItem(AetherBlocks.CARVED_STONE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item CARVED_STONE_SLAB = register("carved_stone_slab", new BlockItem(AetherBlocks.CARVED_STONE_SLAB, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item CARVED_STONE_STAIRS = register("carved_stone_stairs", new BlockItem(AetherBlocks.CARVED_STONE_STAIRS, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item CARVED_STONE_WALL = register("carved_stone_wall", new BlockItem(AetherBlocks.CARVED_STONE_WALL, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item WATCHFUL_CARVED_STONE = register("watchful_carved_stone", new BlockItem(AetherBlocks.WATCHFUL_CARVED_STONE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item SENTRY_STONE = register("sentry_stone", new BlockItem(AetherBlocks.SENTRY_STONE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));

    public static final Item AMBROSIUM_ORE = register("ambrosium_ore", new BlockItem(AetherBlocks.AMBROSIUM_ORE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item AMBROSIUM_BLOCK = register("ambrosium_block", new BlockItem(AetherBlocks.AMBROSIUM_BLOCK, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    
    public static final Item ZANITE_ORE = register("zanite_ore", new BlockItem(AetherBlocks.ZANITE_ORE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item ZANITE_BLOCK = register("zanite_block", new BlockItem(AetherBlocks.ZANITE_BLOCK, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));

    public static final Item GRAVITITE_ORE = register("gravitite_ore", new BlockItem(AetherBlocks.GRAVITITE_ORE, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));
    public static final Item GRAVITITE_BLOCK = register("gravitite_block", new BlockItem(AetherBlocks.GRAVITITE_BLOCK, new Item.Settings().group(AetherItemGroups.AETHER_BLOCKS)));

    public static void init() {
        
    }

    protected static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, AetherRewoven.id(name), item);
    }

    protected static Item register(String name, BlockItem blockItem) {
        return Registry.register(Registry.ITEM, AetherRewoven.id(name), blockItem);
    }
}