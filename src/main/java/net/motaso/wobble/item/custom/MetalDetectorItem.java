package net.motaso.wobble.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.motaso.wobble.item.ModItems;
import net.motaso.wobble.sound.ModSounds;
import net.motaso.wobble.util.InventoryUtil;
import net.motaso.wobble.util.ModTags;

import javax.annotation.Nullable;
import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addDataToTablet(player, positionClicked.below(i), blockState.getBlock());

                    }

                    pContext.getLevel().playSeededSound(null, positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                            ModSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.BLOCKS, 1f, 1f, 0);

                    break;
                }
            }
            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No valuables found!"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void addDataToTablet(Player player, BlockPos below, Block block) {
        ItemStack dataTablet = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        CompoundTag data = new CompoundTag();
        data.putString("wobble.found_ore", "Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")");

        dataTablet.setTag(data);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pToolTipComponents.add(Component.translatable("tooltip.wobble.metal_detector.shift"));
        } else {
            pToolTipComponents.add(Component.translatable("tooltip.wobble.metal_detector"));
        }
        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }
    private boolean isValuableBlock(BlockState state) {
        // Without custom tag
        // return state.is(Blocks.IRON_ORE) || state.is(Blocks.DEEPSLATE_IRON_ORE) || state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.DEEPSLATE_DIAMOND_ORE);

        // with custom tag
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}
