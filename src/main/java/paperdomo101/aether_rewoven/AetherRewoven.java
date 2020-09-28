package paperdomo101.aether_rewoven;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.registry.AetherBiomes;
import paperdomo101.aether_rewoven.registry.AetherBlocks;
import paperdomo101.aether_rewoven.registry.AetherDimensionLayers;
import paperdomo101.aether_rewoven.registry.AetherDimensions;
import paperdomo101.aether_rewoven.registry.AetherEntities;
import paperdomo101.aether_rewoven.registry.AetherItems;
import paperdomo101.aether_rewoven.registry.AetherSounds;

public class AetherRewoven implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "aether_rewoven";
    public static final String MOD_NAME = "Aether Rewoven";

    public static Identifier id(String name) { return new Identifier(MOD_ID, name);}

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
        AetherEntities.init();
        AetherSounds.init();
        AetherBiomes.init();
        AetherDimensions.init();
        AetherDimensionLayers.init();
        log("Aether Rewoven completed init");
    }
}