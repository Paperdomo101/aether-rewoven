package paperdomo101.aether_rewoven.item;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import paperdomo101.aether_rewoven.block.AetherGrassBlock;
import paperdomo101.aether_rewoven.registry.AetherBlocks;
import paperdomo101.aether_rewoven.registry.AetherParticles;

public class AmbrosiumShardItem extends Item {

    public AmbrosiumShardItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Random random = world.random;
        if (blockState.getBlock() == AetherBlocks.AETHER_GRASS_BLOCK && !(Boolean)blockState.get(AetherGrassBlock.ENCHANTED)) {
            world.playSound((PlayerEntity)null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, SoundCategory.BLOCKS, 1.0F, (RANDOM.nextFloat() * 1.4F + 2.8F));
            world.addParticle(AetherParticles.AMBROSIUM_DUST, (double)blockPos.getX() + random.nextDouble(), (double)blockPos.getY() + 1.1D, (double)blockPos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
            world.setBlockState(blockPos, blockState.with(AetherGrassBlock.ENCHANTED, true));
            world.updateNeighbors(blockPos, AetherBlocks.AETHER_GRASS_BLOCK);
            context.getStack().decrement(1);
            return ActionResult.SUCCESS;
      } else {
         return ActionResult.PASS;
      }
   }
}