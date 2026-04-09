package com.noahboos.minecraft.statistique.events;

import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class ItemEventHandler {
    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        ItemStack craftedItemStack = event.getCrafting();
        EquipmentComponentMapper.setStatisticsToItem(craftedItemStack, null);
    }
}
