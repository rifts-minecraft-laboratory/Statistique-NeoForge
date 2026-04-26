package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;

import java.util.HashMap;
import java.util.Map;

public abstract class DefensiveWeaponCore<T extends DefensiveWeaponCore<T>> extends Core<T> {
    protected DefensiveWeaponCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public DefensiveWeaponCore() {
        super();
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        // All the statistics that should be common to defensive weapons will be added here. There are none for now. :3
        return statistics;
    }
}
