package de.ketra.aufgabe8;

import java.util.Map;

public class Difference extends CompoundExpression {
    public Difference(Expression left, Expression right) {
        super(left, right);
        operator = "-";
    }

    @Override
    public double eval(Map<String, Double> values) {
        return left.eval(values) - right.eval(values);
    }
}
