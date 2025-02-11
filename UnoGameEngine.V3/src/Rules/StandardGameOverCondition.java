package Rules;

import Rules.interfaces.GameOverCondition;
import Setup.Player;
import java.util.List;

public class StandardGameOverCondition implements GameOverCondition {
    @Override
    public Player determineWinner(List<Player> players) {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return player;
            }
        }
        return null;
    }
}