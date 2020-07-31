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
        ParticleFactoryRegistry.getInstance().register(AetherParticles.AMBROSIUM_SHINE, provider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> {
			AmbrosiumShineParticle particle = new AmbrosiumShineParticle(world, x, y, z, velocityX, velocityY, velocityZ);
			particle.setSprite(provider);
			return particle;
        });
        ParticleFactoryRegistry.getInstance().register(AetherParticles.AMBROSIUM_DUST, provider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> {
			AmbrosiumDustParticle particle = new AmbrosiumDustParticle(world, x, y, z, velocityX, velocityY, velocityZ, provider);
			particle.setSprite(provider);
			return particle;
        });
        ParticleFactoryRegistry.getInstance().register(AetherParticles.BANEJO_POT_FRAGMENT, provider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> {
			BanejoPotFragmentParticle particle = new BanejoPotFragmentParticle(world, x, y, z, velocityX, velocityY, velocityZ);
			particle.setSprite(provider);
			return particle;
		});
    }
}