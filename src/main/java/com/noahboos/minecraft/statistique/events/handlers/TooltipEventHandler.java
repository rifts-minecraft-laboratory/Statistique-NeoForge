package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

public class TooltipEventHandler {
    @SubscribeEvent
    public static void OnItemTooltip(ItemTooltipEvent event) {
        List<Component> tooltip = event.getToolTip();
        ItemStack itemStack = event.getItemStack();
        Core<?> statistics = EquipmentComponentMapper.getStatisticsFromItem(itemStack);

        if (statistics != null) {
            tooltip.add(Component.empty());
            tooltip.add(Component.translatable("statistiques.tooltip.title"));

            statistics.toMap().forEach((key, value) -> {
                StatisticType statisticType = StatisticType.valueOf(key.toUpperCase());
                tooltip.add(Component.translatable(statisticType.getTranslationKey(), value.value()));
            });
        }
    }
}
