package Rules.interfaces;

import Cards.Card;

public interface CardLegality {
    boolean isLegal(Card cardToPlay, Card topCard);
}
