package net.motaso.wobble.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.motaso.wobble.Wobble;
import net.motaso.wobble.blocks.ModBlocks;
import net.motaso.wobble.item.custom.FuelItem;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Wobble.MODID);

    public static final RegistryObject<CreativeModeTab> WOBBLE_TAB =
            CREATIVE_MODE_TABS.register("wobble_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                            .title(Component.translatable("creativetab.wobble_tab"))
                            .displayItems(((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.SAPPHIRE.get());
                                pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                                pOutput.accept(ModItems.METAL_DETECTOR.get());

                                pOutput.accept(ModItems.STRAWBERRY.get());

                                pOutput.accept(ModItems.SAPPHIRE_STAFF.get());

                                pOutput.accept(ModItems.PINE_CONE.get());

                                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                                pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                                pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                                pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                                pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                                pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

                                pOutput.accept(ModBlocks.SOUND_BLOCK.get());


                            }))
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
