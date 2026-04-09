package com.noahboos.minecraft.statistique.components.definitions.statistics;

import net.minecraft.client.resources.language.I18n;

public enum StatisticType {
    USED_DURABILITY("used_durability", "statistique.used_durability"),
    MINED_BLOCKS("mined_blocks", "statistique.mined_blocks"),
    STRIPPED_BLOCKS("stripped_blocks", "statistique.stripped_blocks");

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
