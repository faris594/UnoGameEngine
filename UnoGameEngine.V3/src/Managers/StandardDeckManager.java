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
        Card topCard = discardPile.remove(discardPile.size() - 1); // Keep the top card
        deck.addAllCards(discardPile); // Add the rest of the discard pile to the deck
        discardPile.clear();
        deck.shuffle(); // Shuffle the deck
        discardPile.add(topCard); // Put the top card back on the discard pile
    }
}