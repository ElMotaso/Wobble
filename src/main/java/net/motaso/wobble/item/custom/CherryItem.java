package net.motaso.wobble.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.motaso.wobble.item.ModItems;

public class CherryItem extends BowlFoodItem {
    public CherryItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        if (pEntityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }



        if (pStack.isEmpty()) {
            return new ItemStack(ModItems.CHERRY_STONE.get());
        } else {
            if (pEntityLiving instanceof Player && !((Player) pEntityLiving).getAbilities().instabuild) {
                ItemStack itemstack = new ItemStack(ModItems.CHERRY_STONE.get());
                Player player = (Player) pEntityLiving;
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }
        }
            return pStack;
    }
}
