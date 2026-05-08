package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;

import java.util.logging.Logger;

public class OnItemPickedUpHandler {
    @SubscribeEvent
    public static void listen(ItemEntityPickupEvent.Post event) {
        if (event.getPlayer().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(ItemEntityPickupEvent.Post event) {
        event.getPlayer().getInventory().forEach(pickedUpItem -> EquipmentComponentMapper.setStatisticsToItem(pickedUpItem, null));

        Logger.getGlobal().info("Statistics has been added to all items in inventory.");
    }
}
