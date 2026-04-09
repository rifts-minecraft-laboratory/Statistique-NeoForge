package com.noahboos.minecraft.statistique.components.definitions.statistics.tools;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;

import java.util.HashMap;
import java.util.Map;

public class ToolCore extends Core {
    //
    public static final Codec<ToolCore> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(ToolCore::fromMap, ToolCore::toMap);

    private static ToolCore fromMap(Map<String, Statistic> map) {
        ToolCore toolCore = new ToolCore();
        toolCore.statistics.putAll(map);
        return toolCore;
    }

    private Map<String, Statistic> toMap() {
        return new HashMap<>(statistics);
    }
}
