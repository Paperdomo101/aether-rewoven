package paperdomo101.aether_rewoven.world.dimension;

import net.fabricmc.fabric.api.dimension.v1.EntityPlacer;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

@SuppressWarnings("deprecation")
public class AetherEntityPlacer implements EntityPlacer {

    public static final AetherEntityPlacer FALL_FROM_AETHER = new AetherEntityPlacer(512);
    public static final AetherEntityPlacer CREATE_PORTAL = new AetherEntityPlacer(64);

	public final int y;

	public AetherEntityPlacer(int y) {
		this.y = y;
	}

	@Override
	public BlockPattern.TeleportTarget placeEntity(Entity teleported, ServerWorld destination, Direction portalDir, double horizontalOffset, double verticalOffset) {
        destination.setBlockState(new BlockPos(-1, 100, 0), Blocks.GLOWSTONE.getDefaultState());
        destination.setBlockState(new BlockPos(-1, 101, 0), Blocks.GLOWSTONE.getDefaultState());
        destination.setBlockState(new BlockPos(-1, 102, 0), Blocks.GLOWSTONE.getDefaultState());
        destination.setBlockState(new BlockPos(-1, 103, 0), Blocks.GLOWSTONE.getDefaultState());
        destination.setBlockState(new BlockPos(-1, 104, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(0, 100, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(0, 104, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(1, 100, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(1, 104, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(2, 100, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(2, 101, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(2, 102, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(2, 103, 0), Blocks.GLOWSTONE.getDefaultState());
		destination.setBlockState(new BlockPos(2, 104, 0), Blocks.GLOWSTONE.getDefaultState());
		return new BlockPattern.TeleportTarget(new Vec3d(0.5, 101, 0.5), Vec3d.ZERO, 0);
	}
}