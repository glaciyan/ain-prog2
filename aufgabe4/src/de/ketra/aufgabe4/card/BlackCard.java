package de.ketra.aufgabe4.card;

public class BlackCard extends Card {
    public BlackCard(Suit color, Rank wert) {
        super(color, wert);
    }

    public BlackCard() {
        super();
    }

    @Override
    public String getColor() {
        return "black";
    }
}
