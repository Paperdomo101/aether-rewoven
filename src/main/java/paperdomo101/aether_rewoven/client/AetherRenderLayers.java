package paperdomo101.aether_rewoven.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import paperdomo101.aether_rewoven.registry.AetherBlocks;

@Environment(EnvType.CLIENT)
public class AetherRenderLayers {
    public static void init() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), 
            AetherBlocks.COLD_AERCLOUD, AetherBlocks.BLUE_AERCLOUD//, AetherBlocks.AETHER_PORTAL, AetherBlocks.CRYSTAL_LOG, 
            //AetherBlocks.PINK_AERCLOUD, AetherBlocks.GOLDEN_AERCLOUD, AetherBlocks.QUICKSOIL_GLASS
        );

        /*BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), 
            AetherBlocks.SKYROOT_LEAVES, AetherBlocks.GOLDEN_OAK_LEAVES, AetherBlocks.HOLIDAY_LEAVES, AetherBlocks.CRYSTAL_LEAVES,
            AetherBlocks.CHERRY_BLOSSOM_LEAVES
        );*/
    }
}