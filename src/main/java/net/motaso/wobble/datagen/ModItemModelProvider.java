package net.motaso.wobble.datagen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ModelFile;
import net.motaso.wobble.Wobble;
import net.motaso.wobble.block.ModBlocks;
import net.motaso.wobble.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Wobble.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RAW_SAPPHIRE);

        simpleItem(ModItems.ALEXANDRITE);
        simpleItem(ModItems.RAW_ALEXANDRITE);

        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.PEAT_BRICK);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.STRAWBERRY_SEEDS);
        simpleItem(ModItems.CORN);
        simpleItem(ModItems.CORN_SEEDS);
        simpleItem(ModItems.CHERRY);
        simpleItem(ModItems.CHERRY_STONE);
        simpleItem(ModItems.KOHLRABI);
        simpleItem(ModItems.KOHLRABI_SEEDS);
        simpleItem(ModItems.BAR_BRAWL_MUSIC_DISC);
        simpleItem(ModItems.NEBO_I_SIMA_MUSIC_DISC);

        simpleItem(ModItems.ALEXANDRITE_HORSE_ARMOR);
        // simpleItem(ModItems.DATA_TABLET); // not possible bc custom item properties (texture change)

        withExistingParent(ModItems.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        simpleBlockItemBlockTexture(ModBlocks.CATMINT);
        simpleBlockItemBlockTexture(ModBlocks.SNAPDRAGON);

        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);

        fenceItem(ModBlocks.SAPPHIRE_FENCE, ModBlocks.SAPPHIRE_BLOCK);
        buttonItem(ModBlocks.SAPPHIRE_BUTTON, ModBlocks.SAPPHIRE_BLOCK);
        wallItem(ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_BLOCK);

        evenSimplerBlockItem(ModBlocks.SAPPHIRE_STAIRS);
        evenSimplerBlockItem(ModBlocks.SAPPHIRE_SLAB);
        evenSimplerBlockItem(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.SAPPHIRE_FENCE_GATE);

        trapdoorItem(ModBlocks.SAPPHIRE_TRAPDOOR);


        simpleBlockItem(ModBlocks.ALEXANDRITE_DOOR);

        fenceItem(ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_BLOCK);
        buttonItem(ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_BLOCK);
        wallItem(ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_BLOCK);

        evenSimplerBlockItem(ModBlocks.ALEXANDRITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.ALEXANDRITE_SLAB);
        evenSimplerBlockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);

        trapdoorItem(ModBlocks.ALEXANDRITE_TRAPDOOR);


        handheldItem(ModItems.SAPPHIRE_SWORD);
        handheldItem(ModItems.SAPPHIRE_PICKAXE);
        handheldItem(ModItems.SAPPHIRE_AXE);
        handheldItem(ModItems.SAPPHIRE_SHOVEL);
        handheldItem(ModItems.SAPPHIRE_HOE);

        handheldItem(ModItems.ALEXANDRITE_SWORD);
        handheldItem(ModItems.ALEXANDRITE_PICKAXE);
        handheldItem(ModItems.ALEXANDRITE_AXE);
        handheldItem(ModItems.ALEXANDRITE_SHOVEL);
        handheldItem(ModItems.ALEXANDRITE_HOE);
        handheldItem(ModItems.ALEXANDRITE_PAXEL);
        handheldItem(ModItems.ALEXANDRITE_HAMMER);


        trimmedArmorItem(ModItems.SAPPHIRE_HELMET);
        trimmedArmorItem(ModItems.SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(ModItems.SAPPHIRE_LEGGINGS);
        trimmedArmorItem(ModItems.SAPPHIRE_BOOTS);

        trimmedArmorItem(ModItems.ALEXANDRITE_HELMET);
        trimmedArmorItem(ModItems.ALEXANDRITE_CHESTPLATE);
        trimmedArmorItem(ModItems.ALEXANDRITE_LEGGINGS);
        trimmedArmorItem(ModItems.ALEXANDRITE_BOOTS);

        complexBlock(ModBlocks.GEM_EMPOWERING_STATION.get());
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MODID = Wobble.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MODID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MODID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MODID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Wobble.MODID,"item/" + item.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Wobble.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Wobble.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Wobble.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Wobble.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Wobble.MODID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Wobble.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(Wobble.MODID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Wobble.MODID,"block/" + item.getId().getPath()));
    }
}