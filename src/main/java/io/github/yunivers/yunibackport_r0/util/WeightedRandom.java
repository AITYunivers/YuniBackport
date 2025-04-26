package io.github.yunivers.yunibackport_r0.util;

import java.util.Collection;
import java.util.Random;

public class WeightedRandom
{
    public static int func_35736_a(Collection<WeightedRandomChoice> collection) {
        int n = 0;
        for (WeightedRandomChoice weightedRandomChoice : collection) {
            n += weightedRandomChoice.weight;
        }
        return n;
    }

    public static WeightedRandomChoice func_35734_a(Random random, Collection<WeightedRandomChoice> collection, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int n2 = random.nextInt(n);
        for (WeightedRandomChoice weightedRandomChoice : collection) {
            if ((n2 -= weightedRandomChoice.weight) >= 0) continue;
            return weightedRandomChoice;
        }
        return null;
    }

    public static WeightedRandomChoice func_35733_a(Random random, Collection<WeightedRandomChoice> collection) {
        return WeightedRandom.func_35734_a(random, collection, WeightedRandom.func_35736_a(collection));
    }

    public static int func_35737_a(WeightedRandomChoice[] weightedRandomChoiceArray) {
        int n = 0;
        for (WeightedRandomChoice weightedRandomChoice : weightedRandomChoiceArray) {
            n += weightedRandomChoice.weight;
        }
        return n;
    }

    public static WeightedRandomChoice func_35732_a(Random random, WeightedRandomChoice[] weightedRandomChoiceArray, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int n2 = random.nextInt(n);
        for (WeightedRandomChoice weightedRandomChoice : weightedRandomChoiceArray) {
            if ((n2 -= weightedRandomChoice.weight) >= 0) continue;
            return weightedRandomChoice;
        }
        return null;
    }

    public static WeightedRandomChoice func_35735_a(Random random, WeightedRandomChoice[] weightedRandomChoiceArray) {
        return WeightedRandom.func_35732_a(random, weightedRandomChoiceArray, WeightedRandom.func_35737_a(weightedRandomChoiceArray));
    }
}
