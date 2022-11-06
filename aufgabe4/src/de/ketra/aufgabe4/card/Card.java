package de.ketra.aufgabe4.card;

public abstract class Card {
    public Suit suit;
    public Rank rank;

    public Card(Suit color, Rank wert) {
        this.suit = color;
        this.rank = wert;
    }

    public Card() {
        this.suit = Suit.HEARTS;
        this.rank = Rank.SEVEN;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public abstract String getColor();

    public enum Suit {
        HEARTS,
    }

    public enum Rank {
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        FOOL,
        KING,
        QUEEN,
        ACE
    }
}
