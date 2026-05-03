package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class OnProjectileImpactResolver {
    public static Core<?> resolveProjectileImpact(ProjectileImpactEvent event, Core<?> statistics) {
        // Behaviour will be implemented here.
        return statistics;
    }
}
