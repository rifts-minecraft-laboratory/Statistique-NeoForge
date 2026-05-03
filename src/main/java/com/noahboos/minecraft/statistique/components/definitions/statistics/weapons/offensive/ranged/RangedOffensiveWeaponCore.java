package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;

import java.util.HashMap;
import java.util.Map;

public abstract class RangedOffensiveWeaponCore<T extends RangedOffensiveWeaponCore<T>> extends OffensiveWeaponCore<T> {
    protected RangedOffensiveWeaponCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public RangedOffensiveWeaponCore() {
        super();
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        statistics.put(StatisticType.HIT_ARROWS.getName(), StatisticType.HIT_ARROWS.getNewStatistic());
        statistics.put(StatisticType.MISSED_ARROWS.getName(), StatisticType.MISSED_ARROWS.getNewStatistic());
        statistics.put(StatisticType.TOTAL_SHOT_ARROWS.getName(), StatisticType.TOTAL_SHOT_ARROWS.getNewStatistic());
        return statistics;
    }
}
