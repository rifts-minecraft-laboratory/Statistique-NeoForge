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
        statistics.put(StatisticType.DAMAGE_DEALT.getName(), StatisticType.DAMAGE_DEALT.getNewStatistic());
        return statistics;
    }
}
