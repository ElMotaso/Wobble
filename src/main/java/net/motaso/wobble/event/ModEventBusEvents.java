package net.motaso.wobble.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.motaso.wobble.Wobble;
import net.motaso.wobble.entity.ModEntities;
import net.motaso.wobble.entity.client.ModModelLayers;
import net.motaso.wobble.entity.client.RhinoModel;
import net.motaso.wobble.entity.custom.RhinoEntity;

@Mod.EventBusSubscriber(modid = Wobble.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
                event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }

}
