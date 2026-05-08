package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.logging.Logger;

public class OnItemCraftedHandler {
    @SubscribeEvent
    public static void listen(PlayerEvent.ItemCraftedEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(PlayerEvent.ItemCraftedEvent event) {
        ItemStack craftedItemStack = event.getCrafting();
        EquipmentComponentMapper.setStatisticsToItem(craftedItemStack, null);

        Logger.getGlobal().info("Statistics has been added: " + craftedItemStack.getDisplayName().getString());
    }
}
