package Actions;

import Actions.interfaces.Action;
import Cards.enums.CardColor;
import Setup.GameManager;

public class WildDrawFourAction implements Action {
    private CardColor selectedColor;

    @Override
    public void apply(GameManager gameManager) {
        System.out.println("Choose a new color:");
        selectedColor = promptForColor(gameManager);

        System.out.println("The next player must draw 4 cards.");
        gameManager.getTurnManager().nextTurn();
        var nextPlayer = gameManager.getPlayers().get(gameManager.getTurnManager().getCurrentPlayerIndex());
        System.out.println(nextPlayer.getName() + " must draw 4 cards.");
        for (int i = 0; i < 4; i++) {
            nextPlayer.drawCard(gameManager.getDeckManager().drawCard());
        }

        if (selectedColor == null) {
            throw new IllegalStateException("No color has been selected for this action.");
        }
        System.out.println("The new color is " + selectedColor);
        gameManager.getTopCard().setColor(selectedColor);
    }

    private CardColor promptForColor(GameManager gameManager) {
        return gameManager.getColorSelector().promptForColor();
    }
}