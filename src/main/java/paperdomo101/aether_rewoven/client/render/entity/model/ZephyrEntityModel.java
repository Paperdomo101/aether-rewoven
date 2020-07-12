package paperdomo101.aether_rewoven.client.render.entity.model;

import com.google.common.collect.ImmutableList;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class ZephyrEntityModel<T extends Entity> extends CompositeEntityModel<T> {
	private final ModelPart body;
	private final ModelPart leftCheek;
	private final ModelPart rightCheek;
	private final ModelPart mouth;
	private final ModelPart tail;
	private final ModelPart tailEnd;
	public static boolean renderOpaque;

	public ZephyrEntityModel(boolean renderOpaque) {
		textureWidth = 64;
		textureHeight = 32;
		ZephyrEntityModel.renderOpaque = renderOpaque;

		body = new ModelPart(this);
		mouth = new ModelPart(this);
		leftCheek = new ModelPart(this);
		rightCheek = new ModelPart(this);
		tailEnd = new ModelPart(this);
		tail = new ModelPart(this);

		body.setPivot(0.0F, 24.0F, 0.0F);
		leftCheek.setPivot(-4.5F, -2.0F, -7.0F);
		rightCheek.setPivot(3.5F, -2.0F, -7.0F);
		mouth.setPivot(-0.5F, -1.5F, -6.5F);
		tail.setPivot(0.0F, -1.5F, 3.25F);
		tailEnd.setPivot(0.0F, -1.0F, 7.25F);

		body.addChild(leftCheek);
		body.addChild(rightCheek);
		body.addChild(mouth);
		body.addChild(tail);
		tail.addChild(tailEnd);

		if (!renderOpaque) {
			leftCheek.setTextureOffset(32, 0).addCuboid(-2.0F, -1.9F, -0.5F, 4.0F, 4.0F, 2.0F, 0.0F, false);
			rightCheek.setTextureOffset(44, 0).addCuboid(-1.0F, -1.9F, -0.5F, 4.0F, 4.0F, 2.0F, 0.0F, false);
			tail.setTextureOffset(40, 6).addCuboid(-2.5F, -3.5F, 4.75F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			tailEnd.setTextureOffset(40, 16).addCuboid(-1.5F, -1.5F, 4.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		} else {
			body.setTextureOffset(0, 14).addCuboid(-5.0F, -6.0F, 2.0F, 10.0F, 6.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addCuboid(-6.0F, -6.0F, -6.0F, 12.0F, 6.0F, 8.0F, 0.0F, false);
			mouth.setTextureOffset(24, 14).addCuboid(-2.0F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		}
	}

	public void setRotationAngle(ModelPart modelPart, float x, float y, float z) {
		modelPart.pivotX = x;
		modelPart.pivotY = y;
		modelPart.pivotZ = z;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertices, light, overlay);
	}

	@Override
	public Iterable<ModelPart> getParts() {
		return ImmutableList.of(this.body, this.mouth, this.leftCheek, this.rightCheek, this.tail, this.tailEnd);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    	float motion = (float)(Math.sin(limbAngle * 20 / 57.2957795) * limbDistance * .5F);
		
		this.tail.pivotX = (float)(Math.sin(limbAngle * 20 / 57.2957795) * limbDistance * 0.75F);
		this.tail.yaw = (float)(Math.sin(limbAngle * 0.5F / 57.2957795) * limbDistance * 0.75F);
		this.tail.pivotY =  -1.5F - motion;
		
		this.tailEnd.pivotX = (float)(Math.sin(limbAngle * 15 / 57.2957795) * limbDistance * 0.85F);
    	this.tailEnd.yaw = this.tail.yaw + 0.25F;
    	this.tailEnd.pivotY =  motion * 1.25F;
	}
}