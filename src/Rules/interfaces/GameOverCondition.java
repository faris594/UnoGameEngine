package Rules.interfaces;

import Setup.Player;
import java.util.List;

public interface GameOverCondition {
    Player determineWinner(List<Player> players);
}