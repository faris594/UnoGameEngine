package Cards;

import Cards.enums.CardColor;
import Cards.enums.CardType;

public class NumberedCard extends Card {
    private int number;

    public NumberedCard(CardColor color, int number) {
        super(color, CardType.NUMBERED, null);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + number;
    }
}