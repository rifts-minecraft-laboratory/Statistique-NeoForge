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
        statistics.put(StatisticType.ARROWS_HIT.getName(), StatisticType.ARROWS_HIT.getNewStatistic());
        statistics.put(StatisticType.ARROWS_MISSED.getName(), StatisticType.ARROWS_MISSED.getNewStatistic());
        statistics.put(StatisticType.ARROWS_SHOT.getName(), StatisticType.ARROWS_SHOT.getNewStatistic());
        return statistics;
    }
}
