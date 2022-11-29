package card;

public class RedCard extends Card {
    public RedCard(Suit color, Rank wert) {
        super(color, wert);
    }

    public RedCard() {
        super();
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
