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
            AetherBlocks.COLD_AERCLOUD, AetherBlocks.BLUE_AERCLOUD, AetherBlocks.PINK_AERCLOUD, AetherBlocks.GOLDEN_AERCLOUD, AetherBlocks.BLACK_ASHCLOUD, AetherBlocks.GRAY_ASHCLOUD,
            AetherBlocks.AETHER_PORTAL, AetherBlocks.QUICKSOIL_GLASS, AetherBlocks.CRYSTAL_LOG
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), 
            AetherBlocks.AMBROSIUM_TORCH, AetherBlocks.AMBROSIUM_WALL_TORCH, AetherBlocks.UNRESTRICTED_SOUL_FIRE, 
            AetherBlocks.SKYROOT_LEAVES, AetherBlocks.SKYROOT_SAPLING, AetherBlocks.SKYROOT_DOOR, AetherBlocks.SKYROOT_TRAPDOOR,
            AetherBlocks.BANEJO_LEAVES, AetherBlocks.BANEJO_SAPLING,//, AetherBlocks.GOLDEN_OAK_LEAVES, AetherBlocks.HOLIDAY_LEAVES, AetherBlocks.CRYSTAL_LEAVES
            /*AetherBlocks.SKYROOT_LEAVES, AetherBlocks.SKYROOT_SAPLING,*/ AetherBlocks.CRYSTAL_DOOR//, AetherBlocks.SKYROOT_TRAPDOOR,
        );
    }
}