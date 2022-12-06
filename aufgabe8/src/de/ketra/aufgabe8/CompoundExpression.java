package de.ketra.aufgabe8;

import java.util.Set;
import java.util.TreeSet;

public abstract class CompoundExpression implements Expression {
    Expression left;
    Expression right;
    String operator;

    public CompoundExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Set<String> getVars() {
        TreeSet<String> set = new TreeSet<>(left.getVars());
        set.addAll(right.getVars());
        return set;
    }

    @Override
    public String toString() {
        return "(%s %s %s)".formatted(left, operator, right);
    }
}
