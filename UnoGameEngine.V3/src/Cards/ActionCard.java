package Cards;

import Actions.interfaces.Action;
import Cards.enums.CardColor;
import Cards.enums.CardType;
import Cards.enums.ActionType;

public class ActionCard extends Card {
    private final ActionType actionType;

    public ActionCard(CardColor color, ActionType actionType, Action action) {
        super(color, CardType.ACTION, action);
        this.actionType = actionType; // Store the ActionType
    }

    public ActionType getActionType() {
        return actionType; // Provide access to the ActionType
    }

    @Override
    public String toString() {
        return this.getColor() + " " + actionType; // Use the ActionType's toString() method
    }
}