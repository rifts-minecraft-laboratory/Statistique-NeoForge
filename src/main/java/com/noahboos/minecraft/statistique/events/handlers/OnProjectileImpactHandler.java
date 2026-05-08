package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.events.utils.OnProjectileImpact;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class OnProjectileImpactHandler {
    @SubscribeEvent
    public static void listen(ProjectileImpactEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(ProjectileImpactEvent event) {
        OnProjectileImpact.processProjectileImpact(event);
    }
}
