package Actions;

import Actions.interfaces.Action;
import Setup.GameManager;

public class SkipAction implements Action {
    @Override
    public void apply(GameManager gameManager) {
        gameManager.getTurnManager().skipNextPlayer();
    }
}
