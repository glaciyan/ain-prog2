package de.ketra.aufgabe8;

import java.util.Map;

public class Sum extends CompoundExpression {
    public Sum(Expression left, Expression right) {
        super(left, right);
        operator = "+";
    }

    @Override
    public double eval(Map<String, Double> values) {
        return left.eval(values) + right.eval(values);
    }
}
