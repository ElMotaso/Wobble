package net.motaso.wobble.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
            .fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1F).alwaysEat().build();
    public static final FoodProperties CHERRY = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f)
            .fast().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 0.01F).alwaysEat().build();

}
