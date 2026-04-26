package com.noahboos.minecraft.statistique.components.definitions.statistics;

import com.mojang.serialization.Codec;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public abstract class Core<T extends Core<T>> {
    protected final Map<String, Statistic> statistics;

    protected Core(Map<String, Statistic> statistics) {
        this.statistics = Map.copyOf(statistics);
    }

    protected Core() {
        this(Map.of());
    }

    protected abstract T create(Map<String, Statistic> statistics);

    protected Map<String, Statistic> getDefaultStatistics() {
        return Map.of();
    }

    protected static <T extends Core<T>> Codec<T> createCodec(Function<Map<String, Statistic>, T> factory) {
        return Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(
            map -> {
                T emptyInstance = factory.apply(Map.of());
                Map<String, Statistic> statistics = new HashMap<>(emptyInstance.getDefaultStatistics());
                statistics.putAll(map);
                return factory.apply(statistics);
            },
            Core::toMap
        );
    }

    public Statistic getStatistic(String name) {
        return statistics.get(name);
    }

    public T setStatistic(String name, float value) {
        Map<String, Statistic> _statistics = new HashMap<>(statistics);
        Statistic statistic = statistics.get(name);

        if (statistic == null) {
            _statistics.put(name, new Statistic(name, value));
        } else {
            _statistics.put(name, statistic.withValue(value));
        }

        return create(_statistics);
    }

    public T incrementStatistic(String name, float value) {
        Statistic statistic = statistics.get(name);
        float _value = (statistic != null ? statistic.value() : 0) + value;
        return setStatistic(name, _value);
    }

    public Map<String, Statistic> toMap() {
        return new HashMap<>(statistics);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Core<?> core = (Core<?>) object;
        return Objects.equals(statistics, core.statistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statistics);
    }
}
