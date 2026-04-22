package com.noahboos.minecraft.statistique.components.utils.statistics;

import com.noahboos.minecraft.statistique.components.DataComponents;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.items.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;

public class EquipmentComponentMapper {
    public static Core getStatisticsFromItem(ItemStack itemStack) {
        if (itemStack.isEmpty()) return null;

        if (itemStack.getItem() instanceof AxeItem) {
            return itemStack.getComponents().get(DataComponents.AXE_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof HoeItem) {
            return itemStack.getComponents().get(DataComponents.HOE_STATISTICS.get());
        }
        if (itemStack.is(ItemTags.PICKAXES)) {
            return itemStack.getComponents().get(DataComponents.PICKAXE_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof ShearsItem) {
            return itemStack.getComponents().get(DataComponents.SHEARS_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof ShovelItem) {
            return itemStack.getComponents().get(DataComponents.SHOVEL_STATISTICS.get());
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
        if (itemStack.is(ItemTags.PICKAXES)) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.PICKAXE_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.PICKAXE_STATISTICS.get(), (PickaxeStatistics) statistics);
            } else {
                itemStack.set(DataComponents.PICKAXE_STATISTICS.get(), new PickaxeStatistics());
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
        if (itemStack.getItem() instanceof ShovelItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.SHOVEL_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.SHOVEL_STATISTICS.get(), (ShovelStatistics) statistics);
            } else {
                itemStack.set(DataComponents.SHOVEL_STATISTICS.get(), new ShovelStatistics());
            }
        }
    }
}
