package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.ArmorCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.DefensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnEntityHurtResolver;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class OnEntityHurtHandler {
    @SubscribeEvent
    public static void listen(LivingDamageEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(LivingDamageEvent.Post event) {
        processAttacker(event);
        processVictim(event);
    }

    private static void processAttacker(LivingDamageEvent.Post event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        ItemStack weapon = event.getSource().getWeaponItem();

        Core<?> mainHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(attacker.getMainHandItem());
        Core<?> offHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(attacker.getOffhandItem());

        if (weapon != null && weapon.is(attacker.getMainHandItem().getItem()) && mainHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAttackerHand(event, mainHandStatistics);
            if (_statistics != null) EquipmentComponentMapper.setStatisticsToItem(attacker.getMainHandItem(), _statistics);
        }

        if (weapon != null && weapon.is(attacker.getOffhandItem().getItem()) && offHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAttackerHand(event, offHandStatistics);
            if (_statistics != null) EquipmentComponentMapper.setStatisticsToItem(attacker.getOffhandItem(), _statistics);
        }
    }

    private static void processVictim(LivingDamageEvent.Post event) {
        processVictimHands(event);
        processVictimArmor(event);
    }

    private static void processVictimHands(LivingDamageEvent.Post event) {
        LivingEntity victim = event.getEntity();

        Core<?> mainHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(victim.getMainHandItem());
        Core<?> offHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(victim.getOffhandItem());

        if (mainHandStatistics instanceof DefensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveVictimHand(event, mainHandStatistics);
            if (_statistics != null) EquipmentComponentMapper.setStatisticsToItem(victim.getMainHandItem(), _statistics);
        }

        if (!(mainHandStatistics instanceof DefensiveWeaponCore<?>) && offHandStatistics instanceof DefensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveVictimHand(event, offHandStatistics);
            if (_statistics != null) EquipmentComponentMapper.setStatisticsToItem(victim.getOffhandItem(), _statistics);
        }
    }

    private static void processVictimArmor(LivingDamageEvent.Post event) {
        LivingEntity victim = event.getEntity();

        List<ItemStack> victimArmor = List.of(
            victim.getItemBySlot(EquipmentSlot.HEAD),
            victim.getItemBySlot(EquipmentSlot.CHEST),
            victim.getItemBySlot(EquipmentSlot.LEGS),
            victim.getItemBySlot(EquipmentSlot.FEET)
        );

        victimArmor.forEach(itemStack -> {
            Core<?> statistics = EquipmentComponentMapper.getStatisticsFromItem(itemStack);

            if (statistics instanceof ArmorCore<?>) {
                Core<?> _statistics = OnEntityHurtResolver.resolveVictimArmor(event, statistics);
                if (_statistics != null) EquipmentComponentMapper.setStatisticsToItem(itemStack, _statistics);
            }
        });
    }
}
