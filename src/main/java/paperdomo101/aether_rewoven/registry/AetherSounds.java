package paperdomo101.aether_rewoven.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;

public class AetherSounds {

    public static final SoundEvent BANEJO_POT_SHATTER = register("block.banejo_pot.shatter");

    public static void init() { }

    private static SoundEvent register(final String name) {
        return Registry.register(Registry.SOUND_EVENT, AetherRewoven.id(name), new SoundEvent(AetherRewoven.id(name)));
    }
}