package de.ketra.aufgabe8;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Var implements Expression {
    String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public double eval(Map<String, Double> values) {
        return values.get(name);
    }

    @Override
    public Set<String> getVars() {
        var set = new TreeSet<String>();
        set.add(name);
        return set;
    }

    @Override
    public void getVars(Set<String> set) {
        set.add(this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
