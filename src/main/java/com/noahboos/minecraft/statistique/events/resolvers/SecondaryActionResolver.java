package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.events.rules.secondary_action.*;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class SecondaryActionResolver {
    private static final List<SecondaryActionRule> RULES = List.of(
        new AxeStrippingRule(),
        new HoeTillingRule(),
        new ShearsHarvestingRule(),
        new ShovelPathingRule()
    );

    public static Core resolve(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        Core updatedStatistics = statistics;
        boolean resolved = false;

        for (SecondaryActionRule rule : RULES) {
            if (rule.matches(event, updatedStatistics)) {
                updatedStatistics = rule.apply(updatedStatistics);
                resolved = true;
            }
        }

        return resolved ? updatedStatistics : null;
    }
}
