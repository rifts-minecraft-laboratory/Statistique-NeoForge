package com.noahboos.minecraft.statistique.components.definitions.statistics.armors;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;

import java.util.HashMap;
import java.util.Map;

public abstract class ArmorCore<T extends ArmorCore<T>> extends Core<T> {
    protected ArmorCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ArmorCore() {
        super();
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        statistics.put(StatisticType.DAMAGES_MITIGATED.getName(), StatisticType.DAMAGES_MITIGATED.getNewStatistic());
        return statistics;
    }
}
