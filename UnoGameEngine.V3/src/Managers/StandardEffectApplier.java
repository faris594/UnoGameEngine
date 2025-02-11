package Managers;

import Actions.interfaces.Action;
import Cards.Card;
import Managers.interfaces.EffectApplier;
import Setup.GameManager;

import java.util.Scanner;

public class StandardEffectApplier implements EffectApplier {
    private final Scanner scanner;

    public StandardEffectApplier() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void applyEffect(Card card, GameManager gameManager) {
        Action action = card.getAction();
        if (action != null) {
            action.apply(gameManager);
        }
    }
}