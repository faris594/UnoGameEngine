package Actions;

import Actions.interfaces.Action;
import Setup.GameManager;

public class ReverseAction implements Action {
    @Override
    public void apply(GameManager gameManager) {
        gameManager.getTurnManager().reverseTurnOrder();
    }
}