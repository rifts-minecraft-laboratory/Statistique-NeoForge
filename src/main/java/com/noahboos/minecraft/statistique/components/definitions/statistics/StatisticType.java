package com.noahboos.minecraft.statistique.components.definitions.statistics;

import net.minecraft.client.resources.language.I18n;

public enum StatisticType {
    USED_DURABILITY("used_durability", "statistique.used_durability"),
    DEWAXED_BLOCKS("dewaxed_blocks", "statistique.dewaxed_blocks"),
    HARVESTED_BLOCKS("harvested_blocks", "statistique.harvested_blocks"),
    MINED_BLOCKS("mined_blocks", "statistique.mined_blocks"),
    REALIZED_SECONDARY_ACTIONS("realized_secondary_actions", "statistique.realized_secondary_actions"),
    SHEARED_ENTITIES("sheared_entities", "statistique.sheared_entities"),
    STRIPPED_BLOCKS("stripped_blocks", "statistique.stripped_blocks"),
    TILLED_BLOCKS("tilled_blocks", "statistique.tilled_blocks"),
    PATHED_BLOCKS("pathed_blocks", "statistique.pathed_blocks");

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
