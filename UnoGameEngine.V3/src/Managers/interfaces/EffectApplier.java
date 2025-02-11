package Managers.interfaces;

import Cards.Card;
import Setup.GameManager;

public interface EffectApplier {
    void applyEffect(Card card, GameManager gameManager);
}
