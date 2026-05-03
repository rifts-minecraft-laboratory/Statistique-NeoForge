package com.noahboos.minecraft.statistique.components.definitions.statistics;

public enum StatisticType {
    ARROWS_HIT("arrows_hit", "hit_arrows"),
    ARROWS_MISSED("arrows_missed", "missed_arrows"),
    ARROWS_SHOT("arrows_shot", "total_shot_arrows"),
    BLOCKS_BROKEN("blocks_broken", "broken_blocks"),
    DAMAGES_BLOCKED("damages_blocked", "blocked_damages"),
    DAMAGES_DEALT("damages_dealt", "dealt_damages"),
    DAMAGES_MITIGATED("damages_mitigated", "mitigated_damages"),
    ENTITIES_KILLED("entities_killed", "killed_entities"),
    ENTITIES_KILLED_HOSTILE("entities_killed_hostile", "killed_hostile_entities"),
    ENTITIES_KILLED_NEUTRAL("entities_killed_neutral", "killed_neutral_entities"),
    ENTITIES_KILLED_PASSIVE("entities_killed_passive", "killed_passive_entities"),
    TRIDENTS_HIT("tridents_hit", "hit_tridents"),
    TRIDENTS_MISSED("tridents_missed", "missed_tridents"),
    TRIDENTS_THROWN("tridents_thrown", "total_thrown_tridents");

    private final String name;
    private final String legacyName;

    StatisticType(String name, String legacyName) {
        this.name = name;
        this.legacyName = legacyName;
    }

    StatisticType(String name) {
        this(name, name);
    }

    public String getName() {
        return name;
    }

    public String getLegacyName() {
        return legacyName;
    }

    public String getTranslationKey() {
        return "statistiques.statistique." + name;
    }

    public Statistic getNewStatistic() {
        return new Statistic(name, 0);
    }
}
