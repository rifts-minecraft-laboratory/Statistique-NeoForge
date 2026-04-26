package com.noahboos.minecraft.statistique.components.definitions.statistics;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record Statistic(String name, float value) {
    public Statistic withValue(float value) {
        return new Statistic(name, value);
    }

    public static final Codec<Statistic> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(Statistic::name),
            Codec.FLOAT.fieldOf("value").forGetter(Statistic::value)
        ).apply(instance, Statistic::new)
    );
}
