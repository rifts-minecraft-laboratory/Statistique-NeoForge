package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnProjectileImpactResolver;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class OnProjectileImpactHandler {
    @SubscribeEvent
    public static void listen(ProjectileImpactEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        handle(event);
    }

    private static void handle(ProjectileImpactEvent event) {
        processProjectileImpact(event);
    }

    private static void processProjectileImpact(ProjectileImpactEvent event) {
        if (!(event.getProjectile().getOwner() instanceof LivingEntity projectileOwner)) return;

        ItemStack weapon = event.getProjectile().getWeaponItem();

        if (weapon.getItem() instanceof TridentItem) {
            processItemStack(event, weapon, weapon);
            return;
        }

        processItemStack(event, weapon, projectileOwner.getMainHandItem());
        processItemStack(event, weapon, projectileOwner.getOffhandItem());
    }

    private static void processItemStack(ProjectileImpactEvent event, ItemStack weapon, ItemStack itemToProcess) {
        if (weapon == ItemStack.EMPTY || !weapon.getItem().equals(itemToProcess.getItem())) return;

        Core<?> statistics = EquipmentComponentMapper.getStatisticsFromItem(itemToProcess);
        if (!(statistics instanceof OffensiveWeaponCore<?>)) return;

        Core<?> _statistics = OnProjectileImpactResolver.resolveProjectileImpact(event, statistics);
        if (_statistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(itemToProcess, _statistics);
    }
}
