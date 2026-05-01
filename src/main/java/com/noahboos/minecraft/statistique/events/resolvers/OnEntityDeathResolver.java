package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class OnEntityDeathResolver {
    public static Core<?> resolveEntityDisposition(LivingDeathEvent event, Core<?> statistics) {
        // TODO - Implement the treatment of the statistics based on the entity disposition.
        return statistics;
    }

    public static Core<?> resolveEntityType(LivingDeathEvent event, Core<?> statistics) {
        // TODO - Implement the treatment of the statistics based on the entity type.
        return statistics;
    }
}
