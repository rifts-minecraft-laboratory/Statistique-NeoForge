package com.noahboos.minecraft.statistique.components.utils.statistics;

import com.noahboos.minecraft.statistique.components.DataComponents;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.items.*;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.hybride.items.TridentStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items.MaceStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items.SwordStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items.BowStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items.CrossbowStatistics;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;

public class EquipmentComponentMapper {
    public static Core getStatisticsFromItem(ItemStack itemStack) {
        if (itemStack.isEmpty()) return null;

        if (itemStack.getItem() instanceof AxeItem) {
            return itemStack.getComponents().get(DataComponents.AXE_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof BowItem) {
            return itemStack.getComponents().get(DataComponents.BOW_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof CrossbowItem) {
            return itemStack.getComponents().get(DataComponents.CROSSBOW_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof HoeItem) {
            return itemStack.getComponents().get(DataComponents.HOE_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof MaceItem) {
            return itemStack.getComponents().get(DataComponents.MACE_STATISTICS.get());
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
        if (itemStack.is(ItemTags.SWORDS)) {
            return itemStack.getComponents().get(DataComponents.SWORD_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof TridentItem) {
            return itemStack.getComponents().get(DataComponents.TRIDENT_STATISTICS.get());
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
        if (itemStack.getItem() instanceof BowItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.BOW_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.BOW_STATISTICS.get(), (BowStatistics) statistics);
            } else {
                itemStack.set(DataComponents.BOW_STATISTICS.get(), new BowStatistics());
            }
        }
        if (itemStack.getItem() instanceof CrossbowItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.CROSSBOW_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.CROSSBOW_STATISTICS.get(), (CrossbowStatistics) statistics);
            } else {
                itemStack.set(DataComponents.CROSSBOW_STATISTICS.get(), new CrossbowStatistics());
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
        if (itemStack.getItem() instanceof MaceItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.MACE_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.MACE_STATISTICS.get(), (MaceStatistics) statistics);
            } else {
                itemStack.set(DataComponents.MACE_STATISTICS.get(), new MaceStatistics());
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
        if (itemStack.is(ItemTags.SWORDS)) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.SWORD_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.SWORD_STATISTICS.get(), (SwordStatistics) statistics);
            } else {
                itemStack.set(DataComponents.SWORD_STATISTICS.get(), new SwordStatistics());
            }
        }
        if (itemStack.getItem() instanceof TridentItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.TRIDENT_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.TRIDENT_STATISTICS.get(), (TridentStatistics) statistics);
            } else {
                itemStack.set(DataComponents.TRIDENT_STATISTICS.get(), new TridentStatistics());
            }
        }
    }
}
