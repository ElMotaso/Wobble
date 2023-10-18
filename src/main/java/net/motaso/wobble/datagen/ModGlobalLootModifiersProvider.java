package net.motaso.wobble.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.motaso.wobble.Wobble;
import net.motaso.wobble.item.ModItems;
import net.motaso.wobble.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Wobble.MODID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ModItems.PINE_CONE.get()));
        add("cherry_from_cherry_leaves", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHERRY_LEAVES).build(),
                LootItemRandomChanceCondition.randomChance(0.33f).build()},
                ModItems.CHERRY.get()));


        add("pine_cone_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build() },
                ModItems.PINE_CONE.get()));
        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build() },
                ModItems.METAL_DETECTOR.get()));
    }
}
