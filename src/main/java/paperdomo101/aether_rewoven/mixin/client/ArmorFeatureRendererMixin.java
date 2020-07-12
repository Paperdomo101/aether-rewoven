package paperdomo101.aether_rewoven.mixin.client;

import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import paperdomo101.aether_rewoven.AetherRewoven;
import paperdomo101.aether_rewoven.item.AetherArmorItem;

@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin {

    @Final
    @Shadow private static Map<String, Identifier> ARMOR_TEXTURE_CACHE;

    @Inject(at = @At("HEAD"), method = "getArmorTexture(Lnet/minecraft/item/ArmorItem;ZLjava/lang/String;)Lnet/minecraft/util/Identifier;", cancellable = true)
    private void addBYGArmor(ArmorItem armorItem, boolean bl, String string, CallbackInfoReturnable<Identifier> cir) {
        if (armorItem instanceof AetherArmorItem) {
            String string3 = AetherRewoven.MOD_ID + ":textures/models/armor/" + ((AetherArmorItem)armorItem).getArmorMaterial().getName() + "_layer_" + (bl ? 2 : 1) + (string == null ? "" : "_" + string) + ".png";
            cir.setReturnValue(ARMOR_TEXTURE_CACHE.computeIfAbsent(string3, Identifier::new));
        }
    }

    // public PlayerEntityRendererMixin(EntityRenderDispatcher dispatcher, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
    //     super(dispatcher, model, shadowRadius);
    // }

	// @Inject(at = @At("TAIL"), method = "init()V")
    // private void PlayerEntityRenderer(CallbackInfo info) {
    //     //this.addFeature(new AetherArmorFeatureRenderer(this, new BipedEntityModel(0.5F), new BipedEntityModel(1.0F)));
    // }
}