package paperdomo101.aether_rewoven;

import net.fabricmc.api.ClientModInitializer;
import paperdomo101.aether_rewoven.client.AetherRenderLayers;

public class AetherClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		AetherRenderLayers.init();
		//AetherEntityRenderers.init();
	}
}