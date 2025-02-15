package Managers.interfaces;

import Cards.Card;

import java.util.List;

public interface DeckManager {
    Card drawCard();
    void shuffleDeck();
    void repopulateDeckFromDiscardPile(List<Card> discardPile);
}

