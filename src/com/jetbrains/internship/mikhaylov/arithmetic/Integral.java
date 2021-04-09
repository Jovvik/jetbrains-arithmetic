package com.jetbrains.internship.mikhaylov.arithmetic;

import java.util.Random;

public class Integral implements Constant {
    private final long value;

    public Integral() {
        value = Math.abs(new Random().nextLong());
    }

    public static Integral generate(Probabilities probabilities) {
        return new Integral();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
