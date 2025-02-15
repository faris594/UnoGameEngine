package Rules;

import Cards.Card;
import Rules.interfaces.CardLegality;
import Rules.interfaces.GameOverCondition;
import Rules.interfaces.Penalty;
import Rules.interfaces.Rules;
import Managers.interfaces.DeckManager;
import Setup.Player;
import java.util.List;

public class StandardRules implements Rules {
    private final CardLegality cardLegality;
    private final Penalty penalty;
    private final GameOverCondition gameOverCondition;

    public StandardRules(CardLegality cardLegality, Penalty penalty, GameOverCondition gameOverCondition) {
        this.cardLegality = cardLegality;
        this.penalty = penalty;
        this.gameOverCondition = gameOverCondition;
    }

    @Override
    public boolean canPlayCard(Card card, Card topCard) {
        return cardLegality.isLegal(card, topCard);
    }

    @Override
    public void applyPenalty(Player player, DeckManager deckManager) {
        penalty.apply(player, deckManager);
    }

    @Override
    public Player isGameOver(List<Player> players) {
        return gameOverCondition.determineWinner(players);
    }
}