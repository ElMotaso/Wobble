package net.motaso.wobble.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.motaso.wobble.Wobble;
import net.motaso.wobble.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Wobble.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB =
            CREATIVE_MODE_TABS.register("tutorial_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                            .title(Component.translatable("creativetab.tutorial_tab"))
                            .displayItems(((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.SAPPHIRE.get());
                                pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                                pOutput.accept(ModItems.METAL_DETECTOR.get());

                                pOutput.accept(ModItems.STRAWBERRY.get());
                                pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                                pOutput.accept(ModItems.CORN.get());
                                pOutput.accept(ModItems.CORN_SEEDS.get());

                                pOutput.accept(ModItems.SAPPHIRE_STAFF.get());
                                pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                                pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                                pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                                pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                                pOutput.accept(ModItems.SAPPHIRE_HOE.get());

                                pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                                pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                                pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                                pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());

                                pOutput.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());

                                pOutput.accept(ModItems.RHINO_SPAWN_EGG.get());

                                pOutput.accept(ModItems.PINE_CONE.get());

                                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                                pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                                pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                                pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                                pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                                pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

                                pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                                pOutput.accept(ModBlocks.GEM_POLISHING_STATION.get());

                                pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_SLAB.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                                pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());

                                pOutput.accept(ModBlocks.CATMINT.get());


                            }))
                            .build());
    public static final RegistryObject<CreativeModeTab> COURSE_TAB =
            CREATIVE_MODE_TABS.register("course_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                            .title(Component.translatable("creativetab.course_tab"))
                            .displayItems(((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.ALEXANDRITE.get());
                                pOutput.accept(ModItems.RAW_ALEXANDRITE.get());

                                pOutput.accept(ModItems.KOHLRABI.get());

                                pOutput.accept(ModItems.PEAT_BRICK.get());

                                pOutput.accept(ModItems.ALEXANDRITE_SWORD.get());
                                pOutput.accept(ModItems.ALEXANDRITE_PICKAXE.get());
                                pOutput.accept(ModItems.ALEXANDRITE_AXE.get());
                                pOutput.accept(ModItems.ALEXANDRITE_SHOVEL.get());
                                pOutput.accept(ModItems.ALEXANDRITE_HOE.get());
                                pOutput.accept(ModItems.ALEXANDRITE_PAXEL.get());
                                pOutput.accept(ModItems.ALEXANDRITE_HAMMER.get());

                                pOutput.accept(ModItems.ALEXANDRITE_HELMET.get());
                                pOutput.accept(ModItems.ALEXANDRITE_CHESTPLATE.get());
                                pOutput.accept(ModItems.ALEXANDRITE_LEGGINGS.get());
                                pOutput.accept(ModItems.ALEXANDRITE_BOOTS.get());

                                pOutput.accept(ModItems.ALEXANDRITE_HORSE_ARMOR.get());


                                pOutput.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                                pOutput.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

                                pOutput.accept(ModBlocks.ALEXANDRITE_ORE.get());
                                pOutput.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                                pOutput.accept(ModBlocks.NETHER_ALEXANDRITE_ORE.get());
                                pOutput.accept(ModBlocks.END_STONE_ALEXANDRITE_ORE.get());

                                pOutput.accept(ModBlocks.ALEXANDRITE_STAIRS.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_SLAB.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_BUTTON.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_FENCE.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_WALL.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_DOOR.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_TRAPDOOR.get());

                                pOutput.accept(ModBlocks.ALEXANDRITE_LAMP.get());


                            }))
                            .build());

    public static final RegistryObject<CreativeModeTab> WOBBLE_TAB =
            CREATIVE_MODE_TABS.register("wobble_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHERRY.get()))
                            .title(Component.translatable("creativetab.wobble_tab"))
                            .displayItems(((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.CHERRY.get());
                                pOutput.accept(ModItems.CHERRY_STONE.get());

                                pOutput.accept(ModItems.NEBO_I_SIMA_MUSIC_DISC.get());
                            }))
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
