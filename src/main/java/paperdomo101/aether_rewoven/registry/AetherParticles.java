package paperdomo101.aether_rewoven.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;

public class AetherParticles {

    public static final DefaultParticleType AETHER_PORTAL = register("aether_portal", false);
    public static final DefaultParticleType AMBROSIUM_DUST = register("ambrosium_dust", false);

	public static DefaultParticleType register(String name, boolean alwaysShow) {
		return Registry.register(Registry.PARTICLE_TYPE, AetherRewoven.id(name), FabricParticleTypes.simple(alwaysShow));
	}
}
