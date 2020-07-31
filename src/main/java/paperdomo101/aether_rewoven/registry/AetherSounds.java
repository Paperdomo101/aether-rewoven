package paperdomo101.aether_rewoven.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;
import paperdomo101.aether_rewoven.AetherRewoven;

public class AetherSounds {

    public static final SoundEvent BANEJO_POT_SHATTER = register("block.banejo_pot.shatter");

    public static final SoundEvent ZEPHYR_AMBIENT = register("entity.zephyr.ambient");
    public static final SoundEvent ZEPHYR_SHOOT = register("entity.zephyr.shoot");
    public static final SoundEvent ZEPHYR_HURT = register("entity.zephyr.hurt");
    public static final SoundEvent ZEPHYR_DEATH = register("entity.zephyr.death");

    public static final SoundEvent MUSIC_DISC_AETHERTUNE = register("music_disc.aethertune");
    public static final SoundEvent MUSIC_DISC_FLIGHT = register("music_disc.flight");

    public static void init() { }

    private static SoundEvent register(final String name) {
        return Registry.register(Registry.SOUND_EVENT, AetherRewoven.id(name), new SoundEvent(AetherRewoven.id(name)));
    }
}