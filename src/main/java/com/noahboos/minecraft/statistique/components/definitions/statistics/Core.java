package com.noahboos.minecraft.statistique.components.definitions.statistics;

import com.mojang.serialization.Codec;

import java.util.HashMap;
import java.util.Map;

public class Core {
    protected final Map<String, Statistic> statistics = new HashMap<>();
    public static final Codec<Core> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(Core::fromMap, Core::toMap);

    public Core() {
        this.statistics.put(
            StatisticType.USED_DURABILITY.getName(),
            StatisticType.USED_DURABILITY.getNewStatistic()
        );
    }

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

    private static Core fromMap(Map<String, Statistic> map) {
        Core core = new Core();
        core.statistics.putAll(map);
        return core;
    }

    private Map<String, Statistic> toMap() {
        return new HashMap<>(statistics);
    }
}
