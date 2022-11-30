package card;

import java.util.Random;

public abstract class Card implements Comparable<Card> {
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

    public static Card random() {
        Random random = new Random();

        Card card = null;
        switch (random.nextInt(0, 2)) {
            case 0:
                card = new RedCard();
                break;
            case 1:
                card = new BlackCard();
                break;
        }

        {
            var values = Rank.values();
            card.rank = values[random.nextInt(values.length)];
        }
        {
            var values = Suit.values();
            card.suit = values[random.nextInt(values.length)];
        }

        return card;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public abstract Color getColor();

    public enum Suit {
        CLOVERS,
        TILES,
        HEARTS,
        PIKES
    }

    public enum Rank {
        ACE,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        KING,
        QUEEN,
        JOKER
    }

    public enum Color {
        RED,
        BLACK
    }

    @Override
    public String toString() {
        return "%s:%s:%s".formatted(this.suit, this.rank, this.getColor().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return rank == card.rank;
    }

    @Override
    public int compareTo(Card o) {
        var color = this.getColor().compareTo(o.getColor());

        if (color == 0) {
            var suit = this.getSuit().compareTo(o.getSuit());

            if (suit == 0) {
                return this.getRank().compareTo(o.getRank());
            }

            return suit;
        }

        return color;
    }
}
