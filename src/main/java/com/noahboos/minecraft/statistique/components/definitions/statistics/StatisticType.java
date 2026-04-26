package com.noahboos.minecraft.statistique.components.definitions.statistics;

import net.minecraft.client.resources.language.I18n;

public enum StatisticType {
    BROKEN_BLOCKS("broken_blocks", "statistique.broken_blocks"),
    BLOCKED_DAMAGES("blocked_damages", "statistique.blocked_damages"),
    DEALT_DAMAGES("dealt_damages", "statistique.dealt_damages"),
    MITIGATED_DAMAGES("mitigated_damages", "statistique.mitigated_damages"),;

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
        return "statistiques." + translationKey;
    }

    public String getTranslation() {
        return I18n.get("statistiques." + translationKey);
    }

    public Statistic getNewStatistic() {
        return new Statistic(name, 0);
    }
}
