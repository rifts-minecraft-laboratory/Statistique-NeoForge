package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.events.handlers.utils.OnEntityHurt;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class EntityEventHandler {
    @SubscribeEvent
    public static void onEntityHurt(LivingDamageEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        OnEntityHurt.processAttacker(event);
    }
}
