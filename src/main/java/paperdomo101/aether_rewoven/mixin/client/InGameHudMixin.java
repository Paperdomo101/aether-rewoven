package paperdomo101.aether_rewoven.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import paperdomo101.aether_rewoven.client.gui.hud.AetherHudRenderer;

@Mixin(InGameHud.class)
public class InGameHudMixin {

  private final AetherHudRenderer hud = new AetherHudRenderer();

  @Shadow
  private MinecraftClient client;

  @Inject(method = "render", at = @At("RETURN"))
  private void render(MatrixStack ms, float partial, CallbackInfo info) {
    hud.render(ms, partial, client);
  }
}