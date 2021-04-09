package com.jetbrains.internship.mikhaylov.arithmetic;

public interface Expression {
    public static Expression generate(Probabilities probabilities) {
        switch (probabilities.getExpressionTable().choose()) {
        case UNARY:
            return UnaryExpression.generate(probabilities);
        case BINARY:
            return BinaryExpression.generate(probabilities);
        case CONSTANT:
            return Constant.generate(probabilities);
        default:
            return null;
        }
    }

    public enum Rule {
        UNARY, BINARY, CONSTANT
    }
}
