package Rules;

import Rules.interfaces.Penalty;
import Managers.interfaces.DeckManager;
import Setup.Player;

public class StandardPenalty implements Penalty {
    @Override
    public void apply(Player player, DeckManager deckManager) {
        System.out.println(player.getName() + " must draw 1 cards as a penalty.");
        for (int i = 0; i < 1; i++) {
            player.drawCard(deckManager.drawCard());
        }
    }
}