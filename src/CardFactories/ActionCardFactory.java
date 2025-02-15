package CardFactories;

import Actions.interfaces.Action;
import Actions.ActionRegistry;
import Cards.ActionCard;
import Cards.Card;
import Cards.enums.CardColor;
import Cards.enums.ActionType;
import CardFactories.interfaces.CardFactory;

public class ActionCardFactory implements CardFactory {
    private final CardColor color;
    private final ActionType actionType;
    private final ActionRegistry actionRegistry;

    public ActionCardFactory(CardColor color, ActionType actionType, ActionRegistry actionRegistry) {
        this.color = color;
        this.actionType = actionType;
        this.actionRegistry = actionRegistry;
    }

    @Override
    public Card createCard() {
        Action cardAction = actionRegistry.createAction(actionType);
        return new ActionCard(color, actionType, cardAction);
    }
}