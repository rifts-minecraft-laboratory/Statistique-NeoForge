package com.noahboos.minecraft.statistique.components.utils.statistics;

import com.noahboos.minecraft.statistique.components.DataComponents;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items.AxeStatistics;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;

public class EquipmentComponentMapper {
    public static Core getStatisticsFromItem(ItemStack itemStack) {
        if (itemStack.isEmpty()) return null;

        if (itemStack.getItem() instanceof AxeItem) {
            return itemStack.getComponents().get(DataComponents.AXE_STATISTICS.get());
        }

        return null;
    }

    public static void setStatisticsToItem(ItemStack itemStack, Core statistics) {
        if (itemStack.isEmpty()) return;

        if (itemStack.getItem() instanceof AxeItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.AXE_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.AXE_STATISTICS.get(), (AxeStatistics) statistics);
            } else {
                itemStack.set(DataComponents.AXE_STATISTICS.get(), new AxeStatistics());
            }
        }
    }
}
