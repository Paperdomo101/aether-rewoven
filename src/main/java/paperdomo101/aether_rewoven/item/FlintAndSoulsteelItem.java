package paperdomo101.aether_rewoven.item;


import java.util.function.Consumer;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import paperdomo101.aether_rewoven.registry.AetherBlocks;

public class FlintAndSoulsteelItem extends Item {
    
    public FlintAndSoulsteelItem(Item.Settings settings) {
       super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        WorldAccess worldAccess = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = worldAccess.getBlockState(blockPos);
        ItemStack stack = context.getStack();

        context.getWorld();
        if (blockState.getBlock() instanceof CampfireBlock && !(Boolean)blockState.get(CampfireBlock.LIT)) {
            if (CampfireBlock.method_30035(blockState)) {
                worldAccess.playSound(playerEntity, blockPos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, RANDOM.nextFloat() * 0.4F + 0.8F);
                
                Direction direction = blockState.get(CampfireBlock.FACING);
                worldAccess.setBlockState(blockPos, (BlockState)(BlockState)Blocks.SOUL_CAMPFIRE.getDefaultState().with(CampfireBlock.LIT, true).with(CampfireBlock.FACING, direction), 11);
                if (playerEntity != null) {
                    stack.damage(1, (LivingEntity) playerEntity, (Consumer<LivingEntity>)((p) -> {
                        ((LivingEntity) p).sendToolBreakStatus(context.getHand());
                    }));
                }
            }
            return ActionResult.success(worldAccess.isClient());
        } else {
            BlockPos blockPos2 = blockPos.offset(context.getSide());
            if (AbstractFireBlock.method_30032(worldAccess, blockPos2)) {
                worldAccess.playSound(playerEntity, blockPos2, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, RANDOM.nextFloat() * 0.4F + 0.8F);
                worldAccess.setBlockState(blockPos2, (BlockState)AetherBlocks.UNRESTRICTED_SOUL_FIRE.getDefaultState(), 11);
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity) {
                    Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos2, itemStack);
                    itemStack.damage(1, (LivingEntity)playerEntity, (Consumer<LivingEntity>)((p) -> {
                        ((LivingEntity) p).sendToolBreakStatus(context.getHand());
                    }));
                }

                return ActionResult.success(worldAccess.isClient());
            } else {
                return ActionResult.FAIL;
            }
        }
    }
}
