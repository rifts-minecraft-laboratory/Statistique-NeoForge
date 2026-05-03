package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;

import java.util.HashMap;
import java.util.Map;

public abstract class OffensiveWeaponCore<T extends OffensiveWeaponCore<T>> extends Core<T> {
    protected OffensiveWeaponCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public OffensiveWeaponCore() {
        super();
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        statistics.put(StatisticType.DAMAGES_DEALT.getName(), StatisticType.DAMAGES_DEALT.getNewStatistic());
        statistics.put(StatisticType.ENTITIES_KILLED.getName(), StatisticType.ENTITIES_KILLED.getNewStatistic());
        statistics.put(StatisticType.ENTITIES_KILLED_HOSTILE.getName(), StatisticType.ENTITIES_KILLED_HOSTILE.getNewStatistic());
        statistics.put(StatisticType.ENTITIES_KILLED_NEUTRAL.getName(), StatisticType.ENTITIES_KILLED_NEUTRAL.getNewStatistic());
        statistics.put(StatisticType.ENTITIES_KILLED_PASSIVE.getName(), StatisticType.ENTITIES_KILLED_PASSIVE.getNewStatistic());
        return statistics;
    }
}
