package com.noahboos.minecraft.statistique.events.handlers.utils;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class OnEntityDeath {
    public static void processEntityDeath(LivingDeathEvent event) {
        processEntityDisposition(event);
        processEntityType(event);
    }

    private static void processEntityDisposition(LivingDeathEvent event) {
        // TODO - Implement the treatment of the entity disposition and call the qualified resolver.
    }

    private static void processEntityType(LivingDeathEvent event) {
        // TODO - Implement the treatment of the entity type and call the qualified resolver.
    }
}
