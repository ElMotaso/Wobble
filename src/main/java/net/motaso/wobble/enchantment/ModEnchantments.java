package net.motaso.wobble.enchantment;

import com.sun.jna.platform.win32.WinDef;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.motaso.wobble.Wobble;

import javax.swing.plaf.PanelUI;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Wobble.MODID);

    public static final RegistryObject<Enchantment> LIGHTNING_STRIKER =
            ENCHANTMENTS.register("lightning_striker",
                    () -> new LighnignStrikeEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
