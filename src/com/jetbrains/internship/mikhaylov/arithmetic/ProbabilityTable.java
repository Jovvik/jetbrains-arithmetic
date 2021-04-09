package com.jetbrains.internship.mikhaylov.arithmetic;

import java.util.Map;
import java.util.Random;

/**
 * A table of probabilites that always sum to 1
 */
public class ProbabilityTable<T> {
    private Map<T, Double> table;

    public ProbabilityTable(Map<T, Double> table) {
        this.table = table;
    }

    public void put(T key, Double val) {
        table.put(key, val);
    }

    public Double get(T key) {
        return table.get(key);
    }

    /**
     * Chooses among all stored values with according probabilities
     * @return chosen value
     */
    public T choose() {
        double total = table.values().stream().mapToDouble(d -> d).sum();
        double rand = new Random().nextDouble();
        for (Map.Entry<T, Double> entry : table.entrySet()) {
            double normalizedProbability = entry.getValue() / total;
            if (rand < normalizedProbability) {
                return entry.getKey();
            } else {
                rand -= normalizedProbability;
            }
        }
        return null;
    }
}
