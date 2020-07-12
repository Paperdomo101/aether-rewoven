package paperdomo101.aether_rewoven;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.registry.AetherBiomes;
import paperdomo101.aether_rewoven.registry.AetherBlocks;
import paperdomo101.aether_rewoven.registry.AetherDimensions;
import paperdomo101.aether_rewoven.registry.AetherItems;
import paperdomo101.aether_rewoven.registry.AetherSounds;

public class AetherRewoven implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "aether_rewoven";
    public static final String MOD_NAME = "Aether Rewoven";

    public static Identifier id(String name) { return new Identifier(MOD_ID, name);}
    
	public static final ItemGroup AETHER_BLOCKS = FabricItemGroupBuilder.build(id("aether_blocks"), () -> new ItemStack(AetherBlocks.AETHER_GRASS_BLOCK));
	public static final ItemGroup AETHER_ITEMS = FabricItemGroupBuilder.build(id("aether_items"), () -> new ItemStack(AetherItems.AMBROSIUM_SHARD));


    //--------------LOGGING----TOOLS-------------------------
    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    public static void log(String message){
        LOGGER.log(Level.INFO, "["+MOD_NAME+"] " + message);
    }
    //-------------------------------------------------------

    @Override
	public void onInitialize() {
        LOGGER = LogManager.getLogger();
        log("Aether Rewoven beginning init");
        AetherItems.init();
		AetherBlocks.init();
        AetherBiomes.init();
        AetherDimensions.init();
        AetherSounds.init();
        log("Aether Rewoven completed init");
    }

	public static String doubleDropNotifier() {return MOD_ID + "_double_drops";}

}