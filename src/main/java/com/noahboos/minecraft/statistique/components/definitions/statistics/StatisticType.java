package com.noahboos.minecraft.statistique.components.definitions.statistics;

import net.minecraft.client.resources.language.I18n;

public enum StatisticType {
    /* Statistic types are declared here. */;

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
}
