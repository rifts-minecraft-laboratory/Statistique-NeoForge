package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnEntityDeathResolver;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

import java.util.logging.Logger;

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

        ItemStack weapon = resolveWeaponUsedForDisposition(event, attacker);
        if (weapon == ItemStack.EMPTY) return;

        if (weapon.getItem() instanceof TridentItem) {
            processItemForEntityDisposition(event, weapon, weapon);
            return;
        }

        processItemForEntityDisposition(event, weapon, attacker.getMainHandItem());
        processItemForEntityDisposition(event, weapon, attacker.getOffhandItem());
    }

    private static ItemStack resolveThrownTrident(ThrownTrident trident) {
        ItemStack weapon = trident.getWeaponItem();

        if (weapon.getItem() instanceof TridentItem) return weapon;

        return ItemStack.EMPTY;
    }

    private static boolean isBowOrCrossbow(ItemStack itemStack) {
        return itemStack.getItem() instanceof BowItem || itemStack.getItem() instanceof CrossbowItem;
    }

    private static ItemStack resolveProjectile(Projectile projectile) {
        if (!(projectile.getOwner() instanceof  LivingEntity projectileOwner)) return ItemStack.EMPTY;

        ItemStack mainHandItemStack = projectileOwner.getMainHandItem();
        if (isBowOrCrossbow(mainHandItemStack)) return mainHandItemStack;

        ItemStack offHandItemStack = projectileOwner.getOffhandItem();
        if (isBowOrCrossbow(offHandItemStack)) return offHandItemStack;

        return ItemStack.EMPTY;
    }

    private static ItemStack resolveWeaponUsedForDisposition(LivingDeathEvent event, LivingEntity attacker) {
        return switch (event.getSource().getDirectEntity()) {
            case ThrownTrident trident -> resolveThrownTrident(trident);
            case Projectile projectile -> resolveProjectile(projectile);
            default -> attacker.getMainHandItem();
        };
    }

    private static void processItemForEntityDisposition(LivingDeathEvent event, ItemStack weapon, ItemStack itemToProcess) {
        if (weapon == ItemStack.EMPTY || !weapon.equals(itemToProcess)) return;

        Core<?> statistics = EquipmentComponentMapper.getStatisticsFromItem(itemToProcess);
        if (!(statistics instanceof OffensiveWeaponCore<?>)) return;

        Core<?> _statistics = OnEntityDeathResolver.resolveEntityDisposition(event, statistics);
        if (_statistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(itemToProcess, _statistics);
        Logger.getGlobal().info("Attacker's item's statistics has been updated: " + _statistics.toMap().toString());
    }

    private static void processEntityType(LivingDeathEvent event) {
        // TODO - Implement the treatment of the entity type and call the qualified resolver.
    }
}
