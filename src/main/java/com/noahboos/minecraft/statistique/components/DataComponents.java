package com.noahboos.minecraft.statistique.components;

import com.noahboos.minecraft.statistique.Statistique;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items.AxeStatistics;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Statistique.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Core>> CORE_STATISTICS = COMPONENTS.register(
        "core_statistics", () -> DataComponentType.<Core>builder().persistent(Core.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ToolCore>> TOOL_CORE_STATISTICS = COMPONENTS.register(
        "tool_core_statistics", () -> DataComponentType.<ToolCore>builder().persistent(ToolCore.CODEC).build()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<AxeStatistics>> AXE_STATISTICS = COMPONENTS.register(
        "axe_statistics", () -> DataComponentType.<AxeStatistics>builder().persistent(AxeStatistics.CODEC).build()
    );
}
