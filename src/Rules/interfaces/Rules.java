package Rules.interfaces;

import Cards.Card;
import Managers.interfaces.DeckManager;
import Setup.Player;

import java.util.List;

public interface Rules {
    boolean canPlayCard(Card cardToPlay, Card topCard);
    void applyPenalty(Player player, DeckManager deckManager);
    Player isGameOver(List<Player> players);
}

