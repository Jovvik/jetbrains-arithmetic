package com.jetbrains.internship.mikhaylov.arithmetic;

public interface Constant extends Expression {
    public static Constant generate(Probabilities probabilities) {
        switch (probabilities.getConstantTable().choose()) {
        case INTEGRAL:
            return Integral.generate(probabilities);
        case FLOATING_POINT:
            return FloatingPoint.generate(probabilities);
        default:
            return null;
        }
    }

    public enum Rule {
        INTEGRAL, FLOATING_POINT
    }
}
