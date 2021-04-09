package com.jetbrains.internship.mikhaylov.arithmetic;

import java.util.List;
import java.util.Random;

public class BinaryExpression implements Expression {
    private final Expression lhs, rhs;
    private final String operator;
    private final boolean isParenthesized;

    public BinaryExpression(Probabilities probabilities) {
        operator = OPERATORS.get(new Random().nextInt(OPERATORS.size()));
        lhs = Expression.generate(probabilities);
        rhs = Expression.generate(probabilities);
        isParenthesized = new Random().nextFloat() < PARENTHESIZED_PROBABILITY;
    }

    public static BinaryExpression generate(Probabilities probabilities) {
        return new BinaryExpression(probabilities);
    }

    @Override
    public String toString() {
        String result = isParenthesized ? "(" : "";
        result += lhs.toString() + " " + operator + " " + rhs.toString();
        result += isParenthesized ? ")" : "";
        return result;
    }

    private static final List<String> OPERATORS = List.of("+", "-", "*", "/", "%");
    private static final double PARENTHESIZED_PROBABILITY = 0.3;
}
