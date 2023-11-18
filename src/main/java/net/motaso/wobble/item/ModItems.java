package net.motaso.wobble.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.motaso.wobble.Wobble;
import net.motaso.wobble.block.ModBlocks;
import net.motaso.wobble.entity.ModEntities;
import net.motaso.wobble.item.custom.*;
import net.motaso.wobble.sound.ModSounds;

public class ModItems {
    // List of Items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Wobble.MODID);

    // Actual Items
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoodProperties.STRAWBERRY)));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry",
            () -> new CherryItem(new Item.Properties().food(ModFoodProperties.CHERRY)));
    public static final RegistryObject<Item> CHERRY_STONE = ITEMS.register("cherry_stone",
            () -> new CherryStoneItem(Blocks.CHERRY_SAPLING, new Item.Properties(), 40));
    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)));

    public static final RegistryObject<Item> KOHLRABI_SEEDS = ITEMS.register("kohlrabi_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KOHLRABI_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
                () -> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> PEAT_BRICK = ITEMS.register("peat_brick",
            () -> new FuelItem(new Item.Properties(), 200));


    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
                () -> new SwordItem(ModToolTiers.SAPPHIRE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
                () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
                () -> new AxeItem(ModToolTiers.SAPPHIRE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
                () -> new ShovelItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
                () -> new HoeItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
            () -> new LevitationStaffItem(new Item.Properties().durability(1024)));
    public static final RegistryObject<Item> RADIATION_STAFF = ITEMS.register("radiation_staff",
            () -> new Item(new Item.Properties().durability(1024)));

    public static final RegistryObject<Item> ALEXANDRITE_SWORD = ITEMS.register("alexandrite_sword",
                () -> new SlowingSwortItem(ModToolTiers.ALEXANDRITE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = ITEMS.register("alexandrite_pickaxe",
                () -> new PickaxeItem(ModToolTiers.ALEXANDRITE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_AXE = ITEMS.register("alexandrite_axe",
                () -> new AxeItem(ModToolTiers.ALEXANDRITE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = ITEMS.register("alexandrite_shovel",
                () -> new ShovelItem(ModToolTiers.ALEXANDRITE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_HOE = ITEMS.register("alexandrite_hoe",
                () -> new HoeItem(ModToolTiers.ALEXANDRITE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_PAXEL = ITEMS.register("alexandrite_paxel",
                () -> new PaxelItem(ModToolTiers.ALEXANDRITE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_HAMMER = ITEMS.register("alexandrite_hammer",
                () -> new HammerItem(ModToolTiers.ALEXANDRITE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_BOW = ITEMS.register("alexandrite_bow",
                () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
                () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
                () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
                () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
                () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));

   public static final RegistryObject<Item> ALEXANDRITE_HELMET = ITEMS.register("alexandrite_helmet",
                () -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_CHESTPLATE = ITEMS.register("alexandrite_chestplate",
                () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> ALEXANDRITE_LEGGINGS = ITEMS.register("alexandrite_leggings",
                () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_BOOTS = ITEMS.register("alexandrite_boots",
                () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ALEXANDRITE_HORSE_ARMOR = ITEMS.register("alexandrite_horse_armor",
                () -> new HorseArmorItem(12, new ResourceLocation(Wobble.MODID, "textures/entity/horse/armor/horse_armor_alexandrite.png"), new Item.Properties()));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
                () -> new DataTabletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
                    () -> new RecordItem(6, ModSounds.BAR_BRAWL, new Item.Properties().stacksTo(1), 2440));
    public static final RegistryObject<Item> NEBO_I_SIMA_MUSIC_DISC = ITEMS.register("nebo_i_sima_music_disc",
                    () -> new RecordItem(6, ModSounds.NEBO_I_SIMA, new Item.Properties().stacksTo(1), 300));

    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    // Has to get registered in Wobble File as well
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
