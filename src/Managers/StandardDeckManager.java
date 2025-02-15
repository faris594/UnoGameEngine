package Managers;

import Cards.Card;
import Deck.Deck;
import Managers.interfaces.DeckManager;

import java.util.List;

public class StandardDeckManager implements DeckManager {
    private final Deck deck;

    public StandardDeckManager(Deck deck) {
        this.deck = deck;
    }

    @Override
    public Card drawCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("The deck is empty!");
        }
        return deck.drawCard();
    }

    @Override
    public void shuffleDeck() {
        deck.shuffle();
    }

    @Override
    public void repopulateDeckFromDiscardPile(List<Card> discardPile) {
        if (discardPile.size() <= 1) {
            throw new IllegalStateException("Cannot repopulate the deck: Discard pile has insufficient cards.");
        }
        Card topCard = discardPile.remove(discardPile.size() - 1);
        deck.addAllCards(discardPile);
        discardPile.clear();
        deck.shuffle();
        discardPile.add(topCard);
    }
}