package paperdomo101.aether_rewoven.client.render.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class ZephyrEntityModel extends EntityModel<Entity> {
	private final ModelPart Body;
	private final ModelPart LeftCheek;
	private final ModelPart RightCheek;
	private final ModelPart Mouth;
	private final ModelPart Tail;
	private final ModelPart Tail2;

	public ZephyrEntityModel() {
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelPart(this);
		Body.setPivot(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 14).addCuboid(-5.0F, -6.0F, 2.0F, 10.0F, 6.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addCuboid(-6.0F, -6.0F, -6.0F, 12.0F, 6.0F, 8.0F, 0.0F, false);

		LeftCheek = new ModelPart(this);
		LeftCheek.setPivot(-4.5F, -2.0F, -7.0F);
		Body.addChild(LeftCheek);
		LeftCheek.setTextureOffset(32, 0).addCuboid(-2.0F, -1.9F, -0.5F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		RightCheek = new ModelPart(this);
		RightCheek.setPivot(3.5F, -2.0F, -7.0F);
		Body.addChild(RightCheek);
		RightCheek.setTextureOffset(44, 0).addCuboid(-1.0F, -1.9F, -0.5F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		Mouth = new ModelPart(this);
		Mouth.setPivot(-0.5F, -1.5F, -6.5F);
		Body.addChild(Mouth);
		Mouth.setTextureOffset(24, 14).addCuboid(-2.0F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Tail = new ModelPart(this);
		Tail.setPivot(0.0F, -1.5F, 3.25F);
		Body.addChild(Tail);
		Tail.setTextureOffset(40, 6).addCuboid(-2.5F, -3.5F, 4.75F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		Tail2 = new ModelPart(this);
		Tail2.setPivot(0.0F, -1.0F, 7.25F);
		Tail.addChild(Tail2);
		Tail2.setTextureOffset(40, 16).addCuboid(-1.5F, -1.5F, 4.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelPart modelPart, float x, float y, float z) {
		modelPart.pivotX = x;
		modelPart.pivotY = y;
		modelPart.pivotZ = z;
	}

	@Override
	public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		Body.render(matrices, vertices, light, overlay);
	}
}