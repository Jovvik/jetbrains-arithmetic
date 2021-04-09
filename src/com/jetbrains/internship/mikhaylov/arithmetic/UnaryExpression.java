package com.jetbrains.internship.mikhaylov.arithmetic;

import java.util.List;
import java.util.Random;

public class UnaryExpression implements Expression {
    private final Expression subExpression;
    private final String operator;

    public UnaryExpression(Probabilities probabilities) {
        operator = OPERATORS.get(new Random().nextInt(OPERATORS.size()));
        subExpression = Expression.generate(probabilities);
    }

    public static UnaryExpression generate(Probabilities probabilities) {
        return new UnaryExpression(probabilities);
    }

    @Override
    public String toString() {
        return "(" + operator + subExpression.toString() + ")";
    }

    private static final List<String> OPERATORS = List.of("+", "-");
}
