package paperdomo101.aether_rewoven;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import paperdomo101.aether_rewoven.client.particle.AetherParticleFactories;
import paperdomo101.aether_rewoven.client.registry.AetherEntityRenderers;
import paperdomo101.aether_rewoven.client.registry.AetherRenderLayers;

@Environment(EnvType.CLIENT)
public class AetherClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		AetherRenderLayers.init();
		AetherParticleFactories.init();
		AetherEntityRenderers.init();
	}
}