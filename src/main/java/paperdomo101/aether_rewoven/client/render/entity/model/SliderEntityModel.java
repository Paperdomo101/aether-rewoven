package paperdomo101.aether_rewoven.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class SliderEntityModel<T extends Entity> extends EntityModel<T> {

    private final ModelPart cube;

    public SliderEntityModel() {
        textureWidth = 128;
        textureHeight = 64;

        cube = new ModelPart(this);
        cube.setPivot(0, -8, 0);
        cube.setTextureOffset(0, 0).addCuboid(-16.0F, 0.0F, -16.0F, 32.0F, 32.0F, 32.0F, 0.0F, false);
    }
    
    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        cube.render(matrices, vertices, light, overlay);
    }
    
}