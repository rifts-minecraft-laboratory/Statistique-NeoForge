package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.logging.Logger;

public class ItemEventHandler {
    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        ItemStack craftedItemStack = event.getCrafting();
        EquipmentComponentMapper.setStatisticsToItem(craftedItemStack, null);

        Logger.getGlobal().info("Statistics has been added: " + craftedItemStack.getDisplayName().getString());
    }

    @SubscribeEvent
    public static void onItemPickedUp(ItemEntityPickupEvent.Post event) {
        if (event.getPlayer().level().isClientSide()) return;

        event.getPlayer().getInventory().forEach(pickedUpItem -> EquipmentComponentMapper.setStatisticsToItem(pickedUpItem, null));

        Logger.getGlobal().info("Statistics has been added to all items in inventory.");
    }
}
