package com.noahboos.minecraft.statistique.components.definitions.statistics;

public enum StatisticType {
    BROKEN_BLOCKS("broken_blocks"),
    BLOCKED_DAMAGES("blocked_damages"),
    DEALT_DAMAGES("dealt_damages"),
    MITIGATED_DAMAGES("mitigated_damages"),;

    private final String name;

    StatisticType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTranslationKey() {
        return "statistiques.statistique." + name;
    }

    public Statistic getNewStatistic() {
        return new Statistic(name, 0);
    }
}
