package de.ketra.aufgabe8;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Constant implements Expression {
    double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double eval(Map<String, Double> values) {
        return value;
    }

    @Override
    public Set<String> getVars() {
        return new TreeSet<>();
    }

    @Override
    public void getVars(Set<String> set) {
    }

    @Override
    public String toString() {
        return getFormatted();
    }

    private String getFormatted() {
        return "%.1f".formatted(this.value);
    }
}
