package com.noahboos.minecraft.statistique.components.utils.statistics;

import com.noahboos.minecraft.statistique.components.DataComponents;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items.AxeStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items.HoeStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items.ShearsStatistics;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;

public class EquipmentComponentMapper {
    public static Core getStatisticsFromItem(ItemStack itemStack) {
        if (itemStack.isEmpty()) return null;

        if (itemStack.getItem() instanceof AxeItem) {
            return itemStack.getComponents().get(DataComponents.AXE_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof HoeItem) {
            return itemStack.getComponents().get(DataComponents.HOE_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof ShearsItem) {
            return itemStack.getComponents().get(DataComponents.SHEARS_STATISTICS.get());
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
        if (itemStack.getItem() instanceof HoeItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.HOE_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.HOE_STATISTICS.get(), (HoeStatistics) statistics);
            } else {
                itemStack.set(DataComponents.HOE_STATISTICS.get(), new HoeStatistics());
            }
        }
        if (itemStack.getItem() instanceof ShearsItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.SHEARS_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.SHEARS_STATISTICS.get(), (ShearsStatistics) statistics);
            } else {
                itemStack.set(DataComponents.SHEARS_STATISTICS.get(), new ShearsStatistics());
            }
        }
    }
}
