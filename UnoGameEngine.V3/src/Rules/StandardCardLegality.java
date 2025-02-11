package Rules;

import Cards.ActionCard;
import Cards.Card;
import Cards.NumberedCard;
import Cards.WildCard;
import Rules.interfaces.CardLegality;

public class StandardCardLegality implements CardLegality {
    @Override
    public boolean isLegal(Card card, Card topCard) {
        if (card instanceof WildCard) {
            return true;
        }

        if (card.getColor().equals(topCard.getColor())) {
            return true;
        }

        if (card instanceof ActionCard && topCard instanceof ActionCard) {
            ActionCard actionCard = (ActionCard) card;
            ActionCard actionTopCard = (ActionCard) topCard;

            if (actionCard.getActionType().equals(actionTopCard.getActionType())) {
                return true;
            }
        }

        if (card instanceof NumberedCard && topCard instanceof NumberedCard) {
            NumberedCard numberedCard = (NumberedCard) card;
            NumberedCard numberedTopCard = (NumberedCard) topCard;

            if (numberedCard.getNumber() == numberedTopCard.getNumber()) {
                return true;
            }
        }

        return false;
    }
}