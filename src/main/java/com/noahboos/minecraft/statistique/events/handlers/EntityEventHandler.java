package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.events.handlers.utils.OnEntityDeath;
import com.noahboos.minecraft.statistique.events.handlers.utils.OnEntityHurt;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class EntityEventHandler {
    @SubscribeEvent
    public static void onEntityHurt(LivingDamageEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        OnEntityHurt.processAttacker(event);
        OnEntityHurt.processVictim(event);
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        OnEntityDeath.processEntityDeath(event);
    }
}
