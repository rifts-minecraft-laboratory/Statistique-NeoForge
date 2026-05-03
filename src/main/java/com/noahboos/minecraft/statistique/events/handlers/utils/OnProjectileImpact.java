package com.noahboos.minecraft.statistique.events.handlers.utils;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnProjectileImpactResolver;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class OnProjectileImpact {
    public static void processProjectileImpact(ProjectileImpactEvent event) {
        if (!(event.getProjectile().getOwner() instanceof LivingEntity projectileOwner)) return;

        ItemStack weapon = event.getProjectile().getWeaponItem();

        processItemStack(event, weapon, projectileOwner.getMainHandItem());
        processItemStack(event, weapon, projectileOwner.getOffhandItem());
    }

    public static void processItemStack(ProjectileImpactEvent event, ItemStack weapon, ItemStack itemToProcess) {
        if (weapon == ItemStack.EMPTY || !weapon.getItem().equals(itemToProcess.getItem())) return;

        Core<?> statistics = EquipmentComponentMapper.getStatisticsFromItem(itemToProcess);
        if (!(statistics instanceof OffensiveWeaponCore<?>)) return;

        Core<?> _statistics = OnProjectileImpactResolver.resolveProjectileImpact(event, statistics);
        if (_statistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(itemToProcess, _statistics);
    }
}
