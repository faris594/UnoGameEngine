package Actions;

import Actions.interfaces.Action;
import Setup.GameManager;

public class DrawTwoAction implements Action {
    @Override
    public void apply(GameManager gameManager) {
        gameManager.getTurnManager().nextTurn();
        var nextPlayer = gameManager.getPlayers().get(gameManager.getTurnManager().getCurrentPlayerIndex());
        System.out.println(nextPlayer.getName() + " must draw 2 cards.");
        for (int i = 0; i < 2; i++) {
            nextPlayer.drawCard(gameManager.getDeckManager().drawCard());
        }
    }
}
