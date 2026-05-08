package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.ArmorCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.DefensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnEntityHurtResolver;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.List;
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

        ItemStack mainHandItemStack = attacker.getMainHandItem();
        Core<?> mainHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        boolean isMainHandOffensiveWeapon = weapon != null && weapon.is(mainHandItemStack.getItem());

        if (isMainHandOffensiveWeapon && mainHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAttackerHand(event, mainHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, _statistics);

                Logger.getGlobal().info("Attacker's main hand statistics has been updated: " + _statistics.toMap().toString());
            }
        }

        ItemStack offHandItemStack = attacker.getOffhandItem();
        Core<?> offHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(offHandItemStack);
        boolean isOffHandOffensiveWeapon = weapon != null && weapon.is(offHandItemStack.getItem());

        if (isOffHandOffensiveWeapon && offHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAttackerHand(event, offHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(offHandItemStack, _statistics);

                Logger.getGlobal().info("Attacker's off hand statistics has been updated: " + _statistics.toMap().toString());
            }
        }
    }

    private static void processVictim(LivingDamageEvent.Post event) {
        processVictimHands(event);
        processVictimArmor(event);
    }

    private static void processVictimHands(LivingDamageEvent.Post event) {
        LivingEntity victim = event.getEntity();

        ItemStack mainHandItemStack = victim.getMainHandItem();
        Core<?> mainHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        boolean isMainHandDefensiveWeapon = mainHandStatistics instanceof DefensiveWeaponCore<?>;

        if (isMainHandDefensiveWeapon) {
            Core<?> _statistics = OnEntityHurtResolver.resolveVictimHand(event, mainHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, _statistics);

                Logger.getGlobal().info("Victim's main hand statistics has been updated: " + _statistics.toMap().toString());
            }
        }

        ItemStack offHandItemStack = victim.getOffhandItem();
        Core<?> offHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(offHandItemStack);
        boolean isOffHandDefensiveWeapon = offHandStatistics instanceof DefensiveWeaponCore<?>;

        if (!isMainHandDefensiveWeapon && isOffHandDefensiveWeapon) {
            Core<?> _statistics = OnEntityHurtResolver.resolveVictimHand(event, offHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(offHandItemStack, _statistics);

                Logger.getGlobal().info("Victim's off hand statistics has been updated: " + _statistics.toMap().toString());
            }
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
                if (_statistics != null) {
                    EquipmentComponentMapper.setStatisticsToItem(itemStack, _statistics);

                    Logger.getGlobal().info("Victim's armor statistics has been updated: " + _statistics.toMap().toString());
                }
            }
        });
    }
}
