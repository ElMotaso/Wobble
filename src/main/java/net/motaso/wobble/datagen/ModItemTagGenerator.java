package net.motaso.wobble.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.motaso.wobble.Wobble;
import net.motaso.wobble.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Wobble.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SAPPHIRE_HELMET.get(),
                        ModItems.SAPPHIRE_CHESTPLATE.get(),
                        ModItems.SAPPHIRE_LEGGINGS.get(),
                        ModItems.SAPPHIRE_BOOTS.get(),

                        ModItems.ALEXANDRITE_HELMET.get(),
                        ModItems.ALEXANDRITE_CHESTPLATE.get(),
                        ModItems.ALEXANDRITE_LEGGINGS.get(),
                        ModItems.ALEXANDRITE_BOOTS.get()
                        );

        this.tag(ItemTags.MUSIC_DISCS)
            .add(ModItems.BAR_BRAWL_MUSIC_DISC.get(),
                    ModItems.NEBO_I_SIMA_MUSIC_DISC.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
            .add(ModItems.BAR_BRAWL_MUSIC_DISC.get(),
                    ModItems.NEBO_I_SIMA_MUSIC_DISC.get());
    }
}
