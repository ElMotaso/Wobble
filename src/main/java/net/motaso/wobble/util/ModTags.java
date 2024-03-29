package net.motaso.wobble.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.motaso.wobble.Wobble;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");
        public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = tag("needs_alexandrite_tool");
        public static final TagKey<Block> PAXEL_MINABLE = tag("mineable/paxel");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Wobble.MODID, name));
        }

    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Wobble.MODID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
