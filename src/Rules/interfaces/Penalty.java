package Rules.interfaces;

import Managers.interfaces.DeckManager;
import Setup.Player;

public interface Penalty {
    void apply(Player player, DeckManager deckManager);
}