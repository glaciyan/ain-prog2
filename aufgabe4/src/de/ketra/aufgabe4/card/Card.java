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

    @Override
    public String toString() {
        return "%s:%s:%s".formatted(this.suit, this.rank, this.getColor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return rank == card.rank;
    }
}
