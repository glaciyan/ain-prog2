package de.ketra.aufgabe8;

import java.util.Map;

public class Quotient extends CompoundExpression {
    public Quotient(Expression left, Expression right) {
        super(left, right);
        operator = "/";
    }

    @Override
    public double eval(Map<String, Double> values) {
        return left.eval(values) / right.eval(values);
    }
}
