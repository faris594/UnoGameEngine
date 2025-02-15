package Cards;

import Actions.interfaces.Action;
import Cards.enums.CardColor;
import Cards.enums.CardType;
import Cards.enums.WildType;

public class WildCard extends Card {
    private final WildType wildType;

    public WildCard(WildType wildType, Action action) {
        super(CardColor.WILD, CardType.WILD, action);
        this.wildType = wildType;
    }

    public WildType getWildType() {
        return wildType;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + wildType;
    }
}