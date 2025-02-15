package Actions;

import Actions.interfaces.Action;
import Cards.enums.CardColor;
import Setup.GameManager;

public class WildChangeColorAction implements Action {
    private CardColor selectedColor;

    @Override
    public void apply(GameManager gameManager) {
        selectedColor = promptForColor(gameManager);

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

