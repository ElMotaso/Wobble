package net.motaso.wobble.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CherryStoneItem extends Item {

    public CherryStoneItem(Properties properties) {
        super(properties);
    }

    /*
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {


            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            InteractionHand hand = pContext.getHand();
            ItemStack itemStack = player.getItemInHand(hand);

            // Check if the block the player is trying to place the stone on is dirt or grass
            BlockState state = pContext.getLevel().getBlockState(positionClicked);
            if (state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK)) {
                // Set the block at the position above to an oak sapling
                pContext.getClickedP
                 .setBlockState(pos.up(), Blocks.OAK_SAPLING.getDefaultState());

                // Consume one cherry stone from the player's hand
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
            }

        }

        return InteractionResult.SUCCESS;
    }

     */
}