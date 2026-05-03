package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.events.handlers.utils.OnProjectileImpact;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class ProjectileEventHandler {
    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        OnProjectileImpact.processProjectileImpact(event);
    }
}
