package paperdomo101.aether_rewoven.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class AshcloudBlock extends TransparentBlock {

    private StatusEffect effect;

    public AshcloudBlock(Settings settings, StatusEffect effect) {
        super(settings);
        this.effect = effect;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(2.0D, 2.0D, 2.0D));
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                livingEntity.addStatusEffect(new StatusEffectInstance(effect, 160));
            }
        }
    }
    

    @Environment(EnvType.CLIENT)
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView view, BlockPos pos) {
        return 1.0F;
    }

    public boolean isTranslucent(BlockState state, BlockView view, BlockPos pos) {
        return true;
    }

    public boolean canSuffocate(BlockState state, BlockView view, BlockPos pos) {
        return false;
    }

    public boolean isSimpleFullBlock(BlockState state, BlockView view, BlockPos pos) {
        return false;
    }
}