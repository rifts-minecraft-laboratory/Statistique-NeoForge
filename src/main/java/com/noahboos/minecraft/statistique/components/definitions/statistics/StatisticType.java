package com.noahboos.minecraft.statistique.components.definitions.statistics;

import net.minecraft.client.resources.language.I18n;

public enum StatisticType {
    USED_DURABILITY("used_durability", "statistique.used_durability"),
    BROKEN_BLOCKS("broken_blocks", "statistique.broken_blocks"),
    CARVED_PUMPKINS("carved_pumpkins", "statistique.carved_pumpkins"),
    DEWAXED_COPPER_BLOCKS("dewaxed_copper_blocks", "statistique.dewaxed_copper_blocks"),
    DISARMED_TRIPWIRES("disarmed_tripwires", "statistique.disarmed_tripwires"),
    DOUSED_CAMPFIRES("doused_campfires", "statistique.doused_campfires"),
    FLATTENED_SOILS("flattened_soils", "statistique.flattened_soils"),
    HARVESTED_BEEHIVES("harvested_beehives", "statistique.harvested_beehives"),
    REALIZED_SECONDARY_ACTIONS("realized_secondary_actions", "statistique.realized_secondary_actions"),
    REMOVED_WOLF_ARMORS("removed_wolf_armors", "statistique.removed_wolf_armors"),
    SCRAPPED_COPPER_BLOCKS("scrapped_copper_blocks", "statistique.scrapped_copper_blocks"),
    SHEARED_SHEEP("sheared_sheep", "statistique.sheared_sheep"),
    STRIPPED_LOGS("stripped_logs", "statistique.stripped_logs"),
    TILLED_SOILS("tilled_soils", "statistique.tilled_soils"),
    TRIMMED_PLANTS("trimmed_plants", "statistique.trimmed_plants");

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
