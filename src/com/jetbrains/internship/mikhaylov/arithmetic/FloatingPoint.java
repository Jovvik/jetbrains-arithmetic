package com.jetbrains.internship.mikhaylov.arithmetic;

import java.util.Random;

public class FloatingPoint implements Constant {
    private final double value;

    public FloatingPoint() {
        value = new Random().nextDouble();
    }

    public static FloatingPoint generate(Probabilities probabilities) {
        return new FloatingPoint();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
