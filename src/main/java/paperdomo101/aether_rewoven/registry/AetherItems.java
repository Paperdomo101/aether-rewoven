package paperdomo101.aether_rewoven.registry;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.item.AetherArmorItem;
import paperdomo101.aether_rewoven.item.AetherDebugItem;
import paperdomo101.aether_rewoven.item.AetherDebugItem.DebugItemType;
import paperdomo101.aether_rewoven.item.AetherMusicDiscItem;
import paperdomo101.aether_rewoven.item.AmbrosiumShardItem;
import paperdomo101.aether_rewoven.item.FlintAndSoulsteelItem;

public class AetherItems {
    
    //Materials
    public static final Item SKYROOT_STICK = register("skyroot_stick", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item AECHOR_PETAL = register("aechor_petal", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item BLUE_SWET_BALL = register("blue_swet_ball", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_SWET_BALL = register("golden_swet_ball", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item DIVINE_LEATHER = register("divine_leather", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_AMBER = register("golden_amber", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_FEATHER = register("golden_feather", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item AMBROSIUM_SHARD = register("ambrosium_shard", new AmbrosiumShardItem(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item ZANITE_GEMSTONE = register("zanite_gemstone", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GRAVITITE = register("gravitite", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item ENCHANTED_GRAVITITE = register("enchanted_gravitite", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item BISMUTH = register("bismuth", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item CRUDE_MELD = register("crude_meld", new AmbrosiumShardItem(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));

    //Tools
    public static final Item FLINT_AND_SOULSTEEL = register("flint_and_soulsteel", new FlintAndSoulsteelItem(new Item.Settings().maxCount(1).maxDamage(128).group(ItemGroup.TOOLS).fireproof()));
    public static final Item COLD_PARACHUTE = register("cold_parachute", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_PARACHUTE = register("golden_parachute", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    
    //WEAPONS
    public static final Item SKYROOT_SWORD = register("skyroot_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item HOLYSTONE_SWORD = register("holystone_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item ZANITE_SWORD = register("zanite_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GRAVITITE_SWORD = register("gravitite_sword", new SwordItem(ToolMaterials.WOOD, 1, 4, new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));

    //Armor
    public static final Item PHOENIX_HELMET = register("phoenix_helmet", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item PHOENIX_CHESTPLATE = register("phoenix_chestplate", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item PHOENIX_LEGGINGS = register("phoenix_leggings", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item PHOENIX_BOOTS = register("phoenix_boots", (Item) new AetherArmorItem(AetherArmorMaterials.PHOENIX, EquipmentSlot.FEET, new Item.Settings().fireproof().group(AetherRewoven.AETHER_ITEMS)));

    //Food
    public static final Item BLUEBERRY = register("blueberry", new Item(new Item.Settings().food(FoodComponents.SWEET_BERRIES).group(AetherRewoven.AETHER_ITEMS)));
    public static final Item BLUE_GUMMY_SWET = register("blue_gummy_swet", new Item(new Item.Settings().food(FoodComponents.BREAD).group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_GUMMY_SWET = register("golden_gummy_swet", new Item(new Item.Settings().food(FoodComponents.BREAD).group(AetherRewoven.AETHER_ITEMS)));
    public static final Item CANDY_CANE = register("candy_cane", new Item(new Item.Settings().food(FoodComponents.APPLE).group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GINGERBREAD_MAN = register("gingerbread_man", new Item(new Item.Settings().food(FoodComponents.COOKIE).group(AetherRewoven.AETHER_ITEMS)));
    public static final Item WHITE_APPLE = register("white_apple", new Item(new Item.Settings().food(FoodComponents.APPLE).group(AetherRewoven.AETHER_ITEMS)));

    //Miscellaneous
    public static final Item SKYROOT_BUCKET = register("skyroot_bucket", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item SKYROOT_WATER_BUCKET = register("skyroot_water_bucket", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item SKYROOT_SPRING_WATER_BUCKET = register("skyroot_spring_water_bucket", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item SKYROOT_POISON_BUCKET = register("skyroot_poison_bucket", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item SKYROOT_MILK_BUCKET = register("skyroot_milk_bucket", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item TRAVEL_LOG = register("travel_log", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item BRONZE_KEY = register("bronze_key", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item SILVER_KEY = register("silver_key", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item GOLDEN_KEY = register("golden_key", new Item(new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item BLUE_SWET_SPAWN_EGG = register("blue_swet_spawn_egg", new SpawnEggItem(AetherEntities.BLUE_SWET, 0x4C8DC4, 0x80B7F2, new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item ZEPHYR_SPAWN_EGG = register("zephyr_spawn_egg", new SpawnEggItem(AetherEntities.ZEPHYR, 0xf2f0e6, 0x8eb1b9, new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item TEMPEST_SPAWN_EGG = register("tempest_spawn_egg", new SpawnEggItem(AetherEntities.TEMPEST, 0x262c34, 0x97ad96, new Item.Settings().group(AetherRewoven.AETHER_ITEMS)));
    public static final Item MUSIC_DISC_AETHERTUNE = register("music_disc_aethertune", new AetherMusicDiscItem(14, AetherSounds.MUSIC_DISC_AETHERTUNE, (new Item.Settings()).maxCount(1).group(AetherRewoven.AETHER_ITEMS).rarity(Rarity.RARE)));
    public static final Item MUSIC_DISC_FLIGHT = register("music_disc_flight", new AetherMusicDiscItem(15, AetherSounds.MUSIC_DISC_FLIGHT, (new Item.Settings()).maxCount(1).group(AetherRewoven.AETHER_ITEMS).rarity(Rarity.RARE)));

    //Debug
    public static final Item DEBUG_PORTAL = register("debug_portal", new AetherDebugItem(new Item.Settings().group(AetherRewoven.AETHER_ITEMS), DebugItemType.portal));

    //BlockItems
    public static final Item AMBROSIUM_TORCH = register("ambrosium_torch", (BlockItem)(new WallStandingBlockItem(AetherBlocks.AMBROSIUM_TORCH, AetherBlocks.AMBROSIUM_WALL_TORCH, (new Item.Settings()).group(AetherRewoven.AETHER_BLOCKS))));

    
    public static void init() {

    }

    protected static <T extends Item> T register(String name, T item) {
      return Registry.register(Registry.ITEM, AetherRewoven.id(name), item);
    }

    protected static Item register(String name, BlockItem blockItem) {
        return Registry.register(Registry.ITEM, AetherRewoven.id(name), blockItem);
    }
}