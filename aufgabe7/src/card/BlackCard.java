package card;

public class BlackCard extends Card {
    public BlackCard(Suit color, Rank wert) {
        super(color, wert);
    }

    public BlackCard() {
        super();
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}
