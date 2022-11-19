package de.ketra.aufgabe6.bibliothek;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;

    private final List<Buch> meineBuecher = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public boolean leihtAus(Buch buch) {
        if (meineBuecher.contains(buch)) {
            return false;
        }

        if (buch.getBesitzer() != null && buch.getBesitzer() != this) {
            return false;
        }

        meineBuecher.add(buch);
        buch.wirdAusgeliehen(this);
        return true;
    }

    public void print() {
        System.out.printf("%s mit %s%n", this.name, this.meineBuecher.size() == 0 ? "keinen Büchern" : "den Büchern " + this.meineBuecher);
    }

    public String getName() {
        return name;
    }

    public boolean gibtZurueck(Buch buch) {
        if (!meineBuecher.contains(buch)) return false;
        meineBuecher.remove(buch);
        buch.wirdZurueckGegeben();
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
