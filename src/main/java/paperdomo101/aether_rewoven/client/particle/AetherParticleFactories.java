package paperdomo101.aether_rewoven.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import paperdomo101.aether_rewoven.registry.AetherParticles;

@Environment(EnvType.CLIENT)
public class AetherParticleFactories {
    public static void init() {
        ParticleFactoryRegistry.getInstance().register(AetherParticles.AETHER_PORTAL, provider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> {
			AetherPortalParticle particle = new AetherPortalParticle(world, x, y, z, velocityX, velocityY, velocityZ);
			particle.setSprite(provider);
			return particle;
		});
    }
}