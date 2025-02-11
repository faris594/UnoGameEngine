package Setup;

import Cards.Card;
import Cards.WildCard;
import Deck.Deck;
import Deck.interfaces.DeckFactory;
import Managers.StandardDeckManager;
import Rules.interfaces.Rules;
import java.util.ArrayList;
import java.util.List;

public class StandardUnoGame extends Game {
    private final int initialHandSize;
    private final List<Card> discardPile = new ArrayList<>();
    private final Deck deck;

    public StandardUnoGame(List<Player> players, Rules rules, DeckFactory deckFactory, int initialHandSize) {
        super(players, rules, null); // DeckManager will be initialized later
        this.initialHandSize = initialHandSize;
        this.deck = deckFactory.createDeck(); // Create the deck using the provided DeckFactory
        this.deckManager = new StandardDeckManager(deck); // Initialize DeckManager here
    }

    @Override
    public void setup() {
        getDeckManager().shuffleDeck(); // Shuffle the deck using the DeckManager

        // Deal cards based on the custom hand size
        for (Player player : getPlayers()) { // Use inherited getPlayers() method
            for (int i = 0; i < initialHandSize; i++) {
                player.drawCard(getDeckManager().drawCard());
            }
        }

        // Set the initial top card (ensure it's not a wild card)
        Card topCard = getDeckManager().drawCard();
        while (topCard instanceof WildCard) { // Ensure the first card isn't a wild card
            getDeckManager().repopulateDeckFromDiscardPile(discardPile); // Repopulate if needed
            getDeckManager().shuffleDeck();
            topCard = getDeckManager().drawCard();
        }
        discardPile.add(topCard); // Add the initial top card to the discard pile
    }

    public List<Card> getDiscardPile() {
        return new ArrayList<>(discardPile); // Return a defensive copy
    }

    public Deck getDeck() {
        return deck;
    }
}