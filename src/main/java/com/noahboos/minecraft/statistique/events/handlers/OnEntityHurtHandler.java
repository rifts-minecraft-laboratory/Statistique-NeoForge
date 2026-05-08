package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.events.utils.OnEntityHurt;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class OnEntityHurtHandler {
    @SubscribeEvent
    public static void listen(LivingDamageEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(LivingDamageEvent.Post event) {
        OnEntityHurt.processAttacker(event);
        OnEntityHurt.processVictim(event);
    }
}
