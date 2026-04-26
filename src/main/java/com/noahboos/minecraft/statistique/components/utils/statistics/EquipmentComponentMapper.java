package com.noahboos.minecraft.statistique.components.utils.statistics;

import com.noahboos.minecraft.statistique.components.DataComponents;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.BootsStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.ChestplateStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.HelmetStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.LeggingsStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.items.*;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.items.ShieldStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.hybride.items.TridentStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items.MaceStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items.SwordStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items.BowStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items.CrossbowStatistics;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

public class EquipmentComponentMapper {
    public static Core<?> getStatisticsFromItem(ItemStack itemStack) {
        if (itemStack.isEmpty()) return null;

        if (itemStack.getItem() instanceof AxeItem) {
            return itemStack.getComponents().get(DataComponents.AXE_STATISTICS.get());
        }
        if (itemStack.is(ItemTags.FOOT_ARMOR)) {
            return itemStack.getComponents().get(DataComponents.BOOTS_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof BowItem) {
            return itemStack.getComponents().get(DataComponents.BOW_STATISTICS.get());
        }
        if (itemStack.is(ItemTags.CHEST_ARMOR)) {
            return itemStack.getComponents().get(DataComponents.CHESTPLATE_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof CrossbowItem) {
            return itemStack.getComponents().get(DataComponents.CROSSBOW_STATISTICS.get());
        }
        if (itemStack.is(ItemTags.HEAD_ARMOR)) {
            return itemStack.getComponents().get(DataComponents.HELMET_STATISTICS.get());
        }
        if (itemStack.getItem() instanceof HoeItem) {
            return itemStack.getComponents().get(DataComponents.HOE_STATISTICS.get());
        }
        if (itemStack.is(ItemTags.LEG_ARMOR)) {
            return itemStack.getComponents().get(DataComponents.LEGGINGS_STATISTICS.get());
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
        if (itemStack.getItem() instanceof ShieldItem) {
            return itemStack.getComponents().get(DataComponents.SHIELD_STATISTICS.get());
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

    public static void setStatisticsToItem(ItemStack itemStack, Core<?> statistics) {
        if (itemStack.isEmpty()) return;

        if (itemStack.getItem() instanceof AxeItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.AXE_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.AXE_STATISTICS.get(), (AxeStatistics) statistics);
            } else {
                itemStack.set(DataComponents.AXE_STATISTICS.get(), new AxeStatistics());
            }
        }
        if (itemStack.is(ItemTags.FOOT_ARMOR)) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.BOOTS_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.BOOTS_STATISTICS.get(), (BootsStatistics) statistics);
            } else {
                itemStack.set(DataComponents.BOOTS_STATISTICS.get(), new BootsStatistics());
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
        if (itemStack.is(ItemTags.CHEST_ARMOR)) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.CHESTPLATE_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.CHESTPLATE_STATISTICS.get(), (ChestplateStatistics) statistics);
            } else {
                itemStack.set(DataComponents.CHESTPLATE_STATISTICS.get(), new ChestplateStatistics());
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
        if (itemStack.is(ItemTags.HEAD_ARMOR)) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.HELMET_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.HELMET_STATISTICS.get(), (HelmetStatistics) statistics);
            } else {
                itemStack.set(DataComponents.HELMET_STATISTICS.get(), new HelmetStatistics());
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
        if (itemStack.is(ItemTags.LEG_ARMOR)) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.LEGGINGS_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.LEGGINGS_STATISTICS.get(), (LeggingsStatistics) statistics);
            } else {
                itemStack.set(DataComponents.LEGGINGS_STATISTICS.get(), new LeggingsStatistics());
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
        if (itemStack.getItem() instanceof ShieldItem) {
            if (statistics == null && itemStack.getComponents().has(DataComponents.SHIELD_STATISTICS.get())) return;
            if (statistics != null) {
                itemStack.set(DataComponents.SHIELD_STATISTICS.get(), (ShieldStatistics) statistics);
            } else {
                itemStack.set(DataComponents.SHIELD_STATISTICS.get(), new ShieldStatistics());
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
