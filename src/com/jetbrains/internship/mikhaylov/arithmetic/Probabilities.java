package com.jetbrains.internship.mikhaylov.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides probabilities for important choices (which rule to apply)
 * 
  * Note: trivial choices are omitted in this class
 */
public class Probabilities {
    public Probabilities() {
        setExpressionTable(new ProbabilityTable<>(new HashMap<>(
            Map.of(
            Expression.Rule.BINARY, 0.5,
            Expression.Rule.UNARY, 0.1,
            Expression.Rule.CONSTANT, 0.2
        ))));
        setConstantTable(new ProbabilityTable<>(Map.of(
            Constant.Rule.INTEGRAL, 0.1,
            Constant.Rule.FLOATING_POINT, 0.1
        )));
    }

    public ProbabilityTable<Constant.Rule> getConstantTable() {
        return constantTable;
    }

    public void setConstantTable(ProbabilityTable<Constant.Rule> constantTable) {
        this.constantTable = constantTable;
    }

    public ProbabilityTable<Expression.Rule> getExpressionTable() {
        expressionTable.put(Expression.Rule.BINARY, expressionTable.get(Expression.Rule.BINARY) * BINARY_DECAY_FACTOR);
        return expressionTable;
    }

    public void setExpressionTable(ProbabilityTable<Expression.Rule> expressionTable) {
        this.expressionTable = expressionTable;
    }

    private ProbabilityTable<Expression.Rule> expressionTable;
    private ProbabilityTable<Constant.Rule> constantTable;
    private static final double BINARY_DECAY_FACTOR = 0.9;
}
