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
        statistics.put(StatisticType.DEALT_DAMAGES.getName(), StatisticType.DEALT_DAMAGES.getNewStatistic());
        statistics.put(StatisticType.KILLED_ENTITIES.getName(), StatisticType.KILLED_ENTITIES.getNewStatistic());
        statistics.put(StatisticType.KILLED_HOSTILE_ENTITIES.getName(), StatisticType.KILLED_HOSTILE_ENTITIES.getNewStatistic());
        statistics.put(StatisticType.KILLED_NEUTRAL_ENTITIES.getName(), StatisticType.KILLED_NEUTRAL_ENTITIES.getNewStatistic());
        statistics.put(StatisticType.KILLED_PASSIVE_ENTITIES.getName(), StatisticType.KILLED_PASSIVE_ENTITIES.getNewStatistic());
        return statistics;
    }
}
