package com.noahboos.minecraft.statistique.components.definitions.statistics;

public enum StatisticType {
    BROKEN_BLOCKS("broken_blocks"),
    BLOCKED_DAMAGES("blocked_damages"),
    DEALT_DAMAGES("dealt_damages"),
    HIT_ARROWS("hit_arrows"),
    HIT_TRIDENTS("hit_tridents"),
    KILLED_ENTITIES("killed_entities"),
    KILLED_HOSTILE_ENTITIES("killed_hostile_entities"),
    KILLED_NEUTRAL_ENTITIES("killed_neutral_entities"),
    KILLED_PASSIVE_ENTITIES("killed_passive_entities"),
    MISSED_ARROWS("missed_arrows"),
    MISSED_TRIDENTS("missed_tridents"),
    MITIGATED_DAMAGES("mitigated_damages"),
    TOTAL_SHOT_ARROWS("total_shot_arrows"),
    TOTAL_THROWN_TRIDENTS("total_thrown_tridents");

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
