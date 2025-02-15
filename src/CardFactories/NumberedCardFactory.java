package CardFactories;

import Cards.Card;
import Cards.enums.CardColor;
import Cards.NumberedCard;
import CardFactories.interfaces.CardFactory;

public class NumberedCardFactory implements CardFactory {
    private final CardColor color;
    private final int number;

    public NumberedCardFactory(CardColor color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public Card createCard() {
        return new NumberedCard(color, number); // Numbered cards have no action
    }
}