package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.events.utils.OnEntityDeath;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class OnEntityDeathHandler {
    @SubscribeEvent
    public static void listen(LivingDeathEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(LivingDeathEvent event) {
        OnEntityDeath.processEntityDeath(event);
    }
}
