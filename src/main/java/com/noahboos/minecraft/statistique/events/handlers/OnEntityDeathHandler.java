package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnEntityDeathResolver;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class OnEntityDeathHandler {
    @SubscribeEvent
    public static void listen(LivingDeathEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(LivingDeathEvent event) {
        processEntityDisposition(event);
        processEntityType(event);
    }

    private static void processEntityDisposition(LivingDeathEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        ItemStack weapon = event.getSource().getDirectEntity() != null
            ? event.getSource().getDirectEntity().getWeaponItem()
            : ItemStack.EMPTY;

        if (weapon == ItemStack.EMPTY) return;

        if (weapon.getItem() instanceof TridentItem) {
            processItemForEntityDisposition(event, weapon, weapon);
            return;
        }

        processItemForEntityDisposition(event, weapon, attacker.getMainHandItem());
        processItemForEntityDisposition(event, weapon, attacker.getOffhandItem());
    }

    private static void processItemForEntityDisposition(LivingDeathEvent event, ItemStack weapon, ItemStack itemToProcess) {
        if (weapon == ItemStack.EMPTY || !weapon.getItem().equals(itemToProcess.getItem())) return;

        Core<?> statistics = EquipmentComponentMapper.getStatisticsFromItem(itemToProcess);
        if (!(statistics instanceof OffensiveWeaponCore<?>)) return;

        Core<?> _statistics = OnEntityDeathResolver.resolveEntityDisposition(event, statistics);
        if (_statistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(itemToProcess, _statistics);
    }

    private static void processEntityType(LivingDeathEvent event) {
        // TODO - Implement the treatment of the entity type and call the qualified resolver.
    }
}
