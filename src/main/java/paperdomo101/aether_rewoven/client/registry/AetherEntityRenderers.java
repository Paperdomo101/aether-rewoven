package paperdomo101.aether_rewoven.client.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.entity.mob.SlimeEntity;
import paperdomo101.aether_rewoven.client.render.entity.BlueSwetEntityRenderer;
import paperdomo101.aether_rewoven.client.render.entity.TempestEntityRenderer;
import paperdomo101.aether_rewoven.client.render.entity.ZephyrEntityRenderer;
import paperdomo101.aether_rewoven.client.render.entity.model.ZephyrEntityModel;
import paperdomo101.aether_rewoven.entity.mob.TempestEntity;
import paperdomo101.aether_rewoven.entity.mob.ZephyrEntity;
import paperdomo101.aether_rewoven.registry.AetherEntities;

@Environment(EnvType.CLIENT)
public class AetherEntityRenderers {

    public static void init() {
        EntityRendererRegistry.INSTANCE.register(AetherEntities.BLUE_SWET, (dispatcher, context) -> {return new BlueSwetEntityRenderer(dispatcher, new SlimeEntityModel<SlimeEntity>(0), 1.0f);});
        EntityRendererRegistry.INSTANCE.register(AetherEntities.ZEPHYR, (dispatcher, context) -> {return new ZephyrEntityRenderer(dispatcher, new ZephyrEntityModel<ZephyrEntity>(ZephyrEntityModel.renderOpaque), 1.5f);});
        EntityRendererRegistry.INSTANCE.register(AetherEntities.TEMPEST, (dispatcher, context) -> {return new TempestEntityRenderer(dispatcher, new ZephyrEntityModel<TempestEntity>(ZephyrEntityModel.renderOpaque), 1.5f);});
    }
}