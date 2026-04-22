package com.noahboos.minecraft.statistique.components;

import com.noahboos.minecraft.statistique.Statistique;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.BlockBreakingToolCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.items.*;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Statistique.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Core>> CORE_STATISTICS = COMPONENTS.register(
        "core_statistics", () -> DataComponentType.<Core>builder().persistent(Core.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockBreakingToolCore>> BLOCK_BREAKING_TOOL_CORE_STATISTICS = COMPONENTS.register(
        "block_breaking_tool_core_statistics", () -> DataComponentType.<BlockBreakingToolCore>builder().persistent(BlockBreakingToolCore.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<AxeStatistics>> AXE_STATISTICS = COMPONENTS.register(
        "axe_statistics", () -> DataComponentType.<AxeStatistics>builder().persistent(AxeStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<HoeStatistics>> HOE_STATISTICS = COMPONENTS.register(
        "hoe_statistics", () -> DataComponentType.<HoeStatistics>builder().persistent(HoeStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<PickaxeStatistics>> PICKAXE_STATISTICS = COMPONENTS.register(
        "pickaxe_statistics", () -> DataComponentType.<PickaxeStatistics>builder().persistent(PickaxeStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ShearsStatistics>> SHEARS_STATISTICS = COMPONENTS.register(
        "shears_statistics", () -> DataComponentType.<ShearsStatistics>builder().persistent(ShearsStatistics.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ShovelStatistics>> SHOVEL_STATISTICS = COMPONENTS.register(
        "shovel_statistics", () -> DataComponentType.<ShovelStatistics>builder().persistent(ShovelStatistics.CODEC).build()
    );
}
