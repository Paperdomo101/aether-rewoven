package paperdomo101.aether_rewoven.block;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import paperdomo101.aether_rewoven.registry.AetherParticles;
import paperdomo101.aether_rewoven.registry.AetherSounds;

public class BanejoPotBlock extends FallingBlock implements Waterloggable {
    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;
    protected final Random random;
    protected static final VoxelShape BASE_SHAPE;
    protected static final VoxelShape BODY_SHAPE;
    protected static final VoxelShape NECK_SHAPE;
    protected static final VoxelShape HEAD_SHAPE;
    protected static final VoxelShape POT_SHAPE;

    public BanejoPotBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.random = new Random();
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return POT_SHAPE;
    }
  
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return POT_SHAPE;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState blockState = (BlockState)((BlockState)(this.getDefaultState().with(FACING, ctx.getPlayerFacing().rotateYClockwise()))).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        return (BlockState)((BlockState)blockState.with(FACING, ctx.getPlayerFacing().rotateYClockwise()).with(WATERLOGGED, false));
    }
    
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
       if ((Boolean)state.get(WATERLOGGED)) {
          world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
       }
 
       return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        this.breakPot(world, hit.getBlockPos());
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        ItemStack itemStack = player.getMainHandStack();
        if (itemStack.getItem() instanceof SwordItem) {
            this.breakPot(world, pos);
        }
    }



    @Override
    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        float fallTime = fallingBlockEntity.timeFalling;
        if (fallTime > 8.0f) {
            this.breakPot(world, pos);
        } 
    }
    
    private void breakPot(World world, BlockPos pos) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
        world.removeBlockEntity(pos);
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), AetherSounds.BANEJO_POT_SHATTER, SoundCategory.BLOCKS, 1.0f, random.nextFloat(), false);

        POT_SHAPE.forEachBox((dx, e, f, g, h, i) -> {
            double j = Math.min(1.0D, g - dx);
            double k = Math.min(1.0D, h - e);
            double l = Math.min(1.0D, i - f);
            int m = Math.max(2, MathHelper.ceil(j / 0.25D));
            int n = Math.max(2, MathHelper.ceil(k / 0.25D));
            int o = Math.max(2, MathHelper.ceil(l / 0.25D));

            for(int p = 0; p < m; ++p) {
                for(int q = 0; q < n; ++q) {
                    for(int r = 0; r < o; ++r) {
                        double s = ((double)p + 0.5D) / (double)m;
                        double t = ((double)q + 0.5D) / (double)n;
                        double u = ((double)r + 0.5D) / (double)o;
                        double v = s * j + dx;
                        double w = t * k + e;
                        double x = u * l + f;
                        world.addParticle(AetherParticles.BANEJO_POT_FRAGMENT, (double)pos.getX() + v, (double)pos.getY() + w, (double)pos.getZ() + x, s - 0.5D, t - 1.0D, u - 0.5D);
                    }
                }
            }
        });
    } 

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public FluidState getFluidState(BlockState state) {
       return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    static {
      FACING = HorizontalFacingBlock.FACING;
      WATERLOGGED = Properties.WATERLOGGED;
      BASE_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
      BODY_SHAPE = Block.createCuboidShape(3.0D, 1.0D, 3.0D, 13.0D, 8.0D, 13.0D);
      NECK_SHAPE = Block.createCuboidShape(5.0D, 9.0D, 5.0D, 11.0D, 11.0D, 11.0D);
      HEAD_SHAPE = Block.createCuboidShape(4.0D, 11.0D, 4.0D, 12.0D, 13.0D, 12.0D);
      POT_SHAPE = VoxelShapes.union(BASE_SHAPE, BODY_SHAPE, NECK_SHAPE, HEAD_SHAPE);
    }
    
}