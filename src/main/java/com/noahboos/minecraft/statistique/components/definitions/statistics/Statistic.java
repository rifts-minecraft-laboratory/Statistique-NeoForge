package com.noahboos.minecraft.statistique.components.definitions.statistics;

public record Statistic(String name, float value) {
    public Statistic withValue(float value) {
        return new Statistic(name, value);
    }
}
