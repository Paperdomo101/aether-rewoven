package paperdomo101.aether_rewoven.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.state.property.AetherProperties;

public class AshcloudBlock extends TransparentBlock {

    public static final BooleanProperty DOUBLE_DROP;
    private StatusEffect effect;

    public AshcloudBlock(Settings settings, StatusEffect effect) {
        super(settings);
        this.setDefaultState((BlockState)(this.stateManager.getDefaultState()).with(DOUBLE_DROP, true));
        this.effect = effect;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            livingEntity.addStatusEffect(new StatusEffectInstance(effect, 160));
        }
    }
    
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(DOUBLE_DROP, false);
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(DOUBLE_DROP);
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

    static {
        DOUBLE_DROP = AetherProperties.DOUBLE_DROP;
    }
}