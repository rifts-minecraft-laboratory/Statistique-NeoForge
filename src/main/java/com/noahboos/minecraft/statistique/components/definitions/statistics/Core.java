package com.noahboos.minecraft.statistique.components.definitions.statistics;

import com.mojang.serialization.Codec;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Core {
    protected final Map<String, Statistic> statistics;
    public static final Codec<Core> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(Core::fromMap, Core::toMap);

    protected Core(Map<String, Statistic> statistics) {
        this.statistics = Map.copyOf(statistics);
    }

    public Core() {
        this(Map.of(
            StatisticType.USED_DURABILITY.getName(),
            StatisticType.USED_DURABILITY.getNewStatistic()
        ));
    }

    public Statistic getStatistic(String name) {
        return statistics.get(name);
    }

    public Core setStatistic(String name, float value) {
        Map<String, Statistic> newStatistics = new HashMap<>(statistics);
        Statistic statistic = statistics.get(name);

        if (statistic == null) {
            newStatistics.put(name, new Statistic(name, value));
        } else {
            newStatistics.put(name, statistic.withValue(value));
        }

        return new Core(newStatistics);
    }

    public Core incrementStatistic(String name, float value) {
        Statistic statistic = statistics.get(name);
        float newValue = (statistic != null ? statistic.value() : 0) + value;
        return setStatistic(name, newValue);
    }

    private static Core fromMap(Map<String, Statistic> map) {
        return new Core(map);
    }

    public Map<String, Statistic> toMap() {
        return new HashMap<>(statistics);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Core core = (Core) object;
        return Objects.equals(statistics, core.statistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statistics);
    }
}
