package com.noahboos.minecraft.statistique.components.definitions.statistics;

import java.util.HashMap;
import java.util.Map;

public class Core {
    protected final Map<String, Statistic> statistics = new HashMap<>();

    public Statistic getStatistic(String name) {
        return statistics.get(name);
    }

    public void setStatistic(String name, float value) {
        Statistic statistic = statistics.get(name);
        if (statistic == null) {
            statistics.put(name, new Statistic(name, value));
        } else {
            statistics.put(name, statistic.withValue(value));
        }
    }
}
