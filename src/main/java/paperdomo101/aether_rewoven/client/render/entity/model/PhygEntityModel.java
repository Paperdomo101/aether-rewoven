package paperdomo101.aether_rewoven.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class PhygEntityModel<T extends Entity> extends PigEntityModel<T> {
    protected ModelPart leftWing;
    protected ModelPart rightWing;

    public PhygEntityModel(float scale) {
        this.torso.addChild(this.leftWing);
        this.torso.addChild(this.rightWing);
        this.leftWing = new ModelPart(this, 0, 0);
        this.rightWing = new ModelPart(this, 0, 0);
    }
    
}