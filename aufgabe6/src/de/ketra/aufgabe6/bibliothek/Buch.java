package de.ketra.aufgabe6.bibliothek;

public class Buch {
    private final String title;
    private Person besitzer;

    public Buch(String title) {
        this.title = title;
    }

    public Person getBesitzer() {
        return besitzer;
    }

    public boolean wirdAusgeliehen(Person besitzer) {
        if (this.besitzer != null) return false;
        this.besitzer = besitzer;
        besitzer.leihtAus(this);
        return true;
    }

    public void print() {
        System.out.printf("%s ausgeliehen von %s%n", this.title, this.besitzer == null ? "niemanden" : this.besitzer.getName());
    }

    public boolean wirdZurueckGegeben() {
        if (besitzer == null) {
            return false;
        }

        Person p = besitzer;
        besitzer = null;
        p.gibtZurueck(this);
        return true;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
