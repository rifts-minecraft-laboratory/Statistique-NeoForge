package com.noahboos.minecraft.statistique.components.definitions.statistics;

import net.minecraft.client.resources.language.I18n;

public enum StatisticType {
    BROKEN_BLOCKS("broken_blocks", "statistique.broken_blocks"),
    DAMAGE_BLOCKED("damage_blocked", "statistique.damage_blocked"),
    DAMAGE_DEALT("damage_dealt", "statistique.damage_dealt"),
    DAMAGE_TAKEN("damage_taken", "statistique.damage_taken"),;

    private final String name;
    private final String translationKey;

    StatisticType(String name, String translationKey) {
        this.name = name;
        this.translationKey = translationKey;
    }

    public String getName() {
        return name;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public String getTranslation() {
        return I18n.get(translationKey);
    }

    public Statistic getNewStatistic() {
        return new Statistic(name, 0);
    }
}
