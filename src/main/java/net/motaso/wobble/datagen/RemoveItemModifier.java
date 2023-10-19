package net.motaso.wobble.datagen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class RemoveItemModifier extends LootModifier {
    private final ResourceLocation targetItemId;
    public static final Codec<RemoveItemModifier> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    LOOT_CONDITIONS_CODEC.fieldOf("conditions").forGetter(modifier -> modifier.conditions),
                    ResourceLocation.CODEC.fieldOf("targetItemId").forGetter(modifier -> modifier.targetItemId)
            ).apply(instance, RemoveItemModifier::new)
    );

    public RemoveItemModifier(LootItemCondition[] conditions, ResourceLocation targetItemId) {
        super(conditions);
        this.targetItemId = targetItemId;
    }


    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        Item targetItem = ForgeRegistries.ITEMS.getValue(targetItemId);
        ObjectArrayList<ItemStack> modifiedLoot = new ObjectArrayList<>();
        for (ItemStack stack : generatedLoot) {
            if (stack.getItem() != targetItem) {
                modifiedLoot.add(stack);
            }
        }
        return modifiedLoot;
    }



    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
