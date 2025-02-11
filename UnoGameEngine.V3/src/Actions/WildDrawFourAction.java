package Actions;

import Actions.interfaces.Action;
import Cards.enums.CardColor;
import Setup.GameManager;

public class WildDrawFourAction implements Action {
    private CardColor selectedColor;

    @Override
    public void apply(GameManager gameManager) {
        // Step 1: Prompt the player to select a color
        System.out.println("Choose a new color:");
        selectedColor = promptForColor(gameManager);

        // Step 2: Apply the penalty (next player draws 4 cards)
        System.out.println("The next player must draw 4 cards.");
        gameManager.getTurnManager().nextTurn(); // Move to the next player
        var nextPlayer = gameManager.getPlayers().get(gameManager.getTurnManager().getCurrentPlayerIndex());
        System.out.println(nextPlayer.getName() + " must draw 4 cards.");
        for (int i = 0; i < 4; i++) {
            nextPlayer.drawCard(gameManager.getDeckManager().drawCard());
        }

        // Step 3: Apply the selected color
        if (selectedColor == null) {
            throw new IllegalStateException("No color has been selected for this action.");
        }
        System.out.println("The new color is " + selectedColor);
        gameManager.getTopCard().setColor(selectedColor); // Update the top card's color
    }

    private CardColor promptForColor(GameManager gameManager) {
        // Reuse the ColorSelector logic from GameManager
        return gameManager.getColorSelector().promptForColor();
    }
}