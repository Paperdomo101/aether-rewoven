package paperdomo101.aether_rewoven.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class AetherSkyProperties extends SkyProperties {

    private final float[] rgba = new float[4];

    public AetherSkyProperties() {
        super(8.0F, true, SkyProperties.SkyType.NORMAL, false, false);
    }

    public Vec3d adjustSkyColor(Vec3d color, float sunHeight) {
        return color.multiply((double)(sunHeight * 0.94F + 0.06F), (double)(sunHeight * 0.94F + 0.06F), (double)(sunHeight * 0.91F + 0.09F));
    }

    public boolean useThickFog(int camX, int camY) {
        return false;
    }

    @Override
    public float[] getSkyColor(float skyAngle, float tickDelta) {
        float f2 = 0.4F;
        float f3 = MathHelper.cos(skyAngle * 3.141593F * 2.0F) - 0.0F;
        float f4 = -0F;

        if (f3 >= f4 - f2 && f3 <= f4 + f2) {
            float f5 = (f3 - f4) / f2 * 0.5F + 0.5F;
            float f6 = 1.0F - (1.0F - MathHelper.sin(f5 * 3.141593F)) * 0.99F;
            f6 *= f6;
            this.rgba[0] = f5 * 0.3F + 0.1F;
            this.rgba[1] = f5 * f5 * 0.7F + 0.2F;
            this.rgba[2] = f5 * f5 * 0.7F + 0.2F;
            this.rgba[3] = f6;
            return this.rgba;
        }
        else {
            return null;
        }
    }
}
