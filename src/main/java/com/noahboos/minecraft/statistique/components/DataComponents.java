package com.noahboos.minecraft.statistique.components;

import com.noahboos.minecraft.statistique.Statistique;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.BootsStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.ChestplateStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.HelmetStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items.LeggingsStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.items.*;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.items.ShieldStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.hybride.items.TridentStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items.MaceStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items.SwordStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items.BowStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items.CrossbowStatistics;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Statistique.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<AxeStatistics>> AXE_STATISTICS = COMPONENTS.register(
        "axe_statistics", () -> DataComponentType.<AxeStatistics>builder().persistent(AxeStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BootsStatistics>> BOOTS_STATISTICS = COMPONENTS.register(
        "boots_statistics", () -> DataComponentType.<BootsStatistics>builder().persistent(BootsStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BowStatistics>> BOW_STATISTICS = COMPONENTS.register(
        "bow_statistics", () -> DataComponentType.<BowStatistics>builder().persistent(BowStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ChestplateStatistics>> CHESTPLATE_STATISTICS = COMPONENTS.register(
        "chestplate_statistics", () -> DataComponentType.<ChestplateStatistics>builder().persistent(ChestplateStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CrossbowStatistics>> CROSSBOW_STATISTICS = COMPONENTS.register(
        "crossbow_statistics", () -> DataComponentType.<CrossbowStatistics>builder().persistent(CrossbowStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<HelmetStatistics>> HELMET_STATISTICS = COMPONENTS.register(
        "helmet_statistics", () -> DataComponentType.<HelmetStatistics>builder().persistent(HelmetStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<HoeStatistics>> HOE_STATISTICS = COMPONENTS.register(
        "hoe_statistics", () -> DataComponentType.<HoeStatistics>builder().persistent(HoeStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<LeggingsStatistics>> LEGGINGS_STATISTICS = COMPONENTS.register(
        "leggings_statistics", () -> DataComponentType.<LeggingsStatistics>builder().persistent(LeggingsStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MaceStatistics>> MACE_STATISTICS = COMPONENTS.register(
        "mace_statistics", () -> DataComponentType.<MaceStatistics>builder().persistent(MaceStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<PickaxeStatistics>> PICKAXE_STATISTICS = COMPONENTS.register(
        "pickaxe_statistics", () -> DataComponentType.<PickaxeStatistics>builder().persistent(PickaxeStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ShearsStatistics>> SHEARS_STATISTICS = COMPONENTS.register(
        "shears_statistics", () -> DataComponentType.<ShearsStatistics>builder().persistent(ShearsStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ShieldStatistics>> SHIELD_STATISTICS = COMPONENTS.register(
        "shield_statistics", () -> DataComponentType.<ShieldStatistics>builder().persistent(ShieldStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ShovelStatistics>> SHOVEL_STATISTICS = COMPONENTS.register(
        "shovel_statistics", () -> DataComponentType.<ShovelStatistics>builder().persistent(ShovelStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SwordStatistics>> SWORD_STATISTICS = COMPONENTS.register(
        "sword_statistics", () -> DataComponentType.<SwordStatistics>builder().persistent(SwordStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TridentStatistics>> TRIDENT_STATISTICS = COMPONENTS.register(
        "trident_statistics", () -> DataComponentType.<TridentStatistics>builder().persistent(TridentStatistics.CODEC).build()
    );
}
