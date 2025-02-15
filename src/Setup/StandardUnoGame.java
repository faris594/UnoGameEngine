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
        super(players, rules, null);
        this.initialHandSize = initialHandSize;
        this.deck = deckFactory.createDeck();
        this.deckManager = new StandardDeckManager(deck);
    }

    @Override
    public void setup() {
        getDeckManager().shuffleDeck();

        for (Player player : getPlayers()) {
            for (int i = 0; i < initialHandSize; i++) {
                player.drawCard(getDeckManager().drawCard());
            }
        }


        Card topCard = getDeckManager().drawCard();
        while (topCard instanceof WildCard) {
            getDeckManager().repopulateDeckFromDiscardPile(discardPile);
            getDeckManager().shuffleDeck();
            topCard = getDeckManager().drawCard();
        }
        discardPile.add(topCard);
    }

    public List<Card> getDiscardPile() {
        return new ArrayList<>(discardPile);
    }

    public Deck getDeck() {
        return deck;
    }
}