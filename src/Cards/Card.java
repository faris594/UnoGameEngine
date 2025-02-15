package Cards;

import Actions.interfaces.Action;
import Cards.enums.CardColor;
import Cards.enums.CardType;

public abstract class Card {
    protected CardColor color;
    protected CardType type;
    protected Action action;

    public Card(CardColor color, CardType type, Action action) {
        this.color = color;
        this.type = type;
        this.action = action;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public CardType getType() {
        return type;
    }

    public Action getAction() {
        return this.action;
    }

    @Override
    public abstract String toString();
}
