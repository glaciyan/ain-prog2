package de.ketra.aufgabe4.card;

public class RedCard extends Card {
    public RedCard(Suit color, Rank wert) {
        super(color, wert);
    }

    public RedCard() {
        super();
    }

    @Override
    public String getColor() {
        return "red";
    }
}
