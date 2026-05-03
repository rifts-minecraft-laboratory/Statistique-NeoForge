package com.noahboos.minecraft.statistique.components.definitions.statistics;

public enum StatisticType {
    BROKEN_BLOCKS("broken_blocks"),
    BLOCKED_DAMAGES("blocked_damages"),
    DEALT_DAMAGES("dealt_damages"),
    HIT_ARROWS("hit_arrows"),
    KILLED_ENTITIES("killed_entities"),
    KILLED_HOSTILE_ENTITIES("killed_hostile_entities"),
    KILLED_NEUTRAL_ENTITIES("killed_neutral_entities"),
    KILLED_PASSIVE_ENTITIES("killed_passive_entities"),
    MISSED_ARROWS("missed_arrows"),
    MITIGATED_DAMAGES("mitigated_damages"),
    TOTAL_SHOT_ARROWS("total_shot_arrows"),;

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
