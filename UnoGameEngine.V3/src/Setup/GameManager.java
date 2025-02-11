package Setup;

import Actions.ColorSelector;
import Actions.interfaces.Action;
import Cards.Card;
import Managers.interfaces.DeckManager;
import Managers.interfaces.EffectApplier;
import Managers.interfaces.TurnManager;
import Rules.interfaces.Rules;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private final DeckManager deckManager;
    private final TurnManager turnManager;
    private final EffectApplier effectApplier;
    private final Rules rules;
    private final List<Player> players;
    private final List<Card> discardPile = new ArrayList<>();
    private final ColorSelector colorSelector;

    public GameManager(DeckManager deckManager, TurnManager turnManager, EffectApplier effectApplier, Rules rules, List<Player> players) {
        this.deckManager = deckManager;
        this.turnManager = turnManager;
        this.effectApplier = effectApplier;
        this.rules = rules;
        this.players = new ArrayList<>(players);
        this.colorSelector = new ColorSelector(new Scanner(System.in));
    }

    public void startGame() {
        System.out.println("Starting the game!");
        while (true) {
            playTurn();
            Player winner = rules.isGameOver(players);
            if (winner != null) {
                endGame(winner);
                break;
            }
            turnManager.nextTurn();
        }
    }

    public void playTurn() {
        Player currentPlayer = players.get(turnManager.getCurrentPlayerIndex());
        System.out.println("\nTop card: " + getTopCard() + " (Current color: " + getTopCard().getColor() + ")");
        System.out.println("It's " + currentPlayer.getName() + "'s turn.");
        currentPlayer.displayHand();

        int cardIndex = promptForCardIndex(currentPlayer);
        if (cardIndex == 0) {
            System.out.println(currentPlayer.getName() + " draws a card.");
            currentPlayer.drawCard(deckManager.drawCard());
            return;
        }

        Card chosenCard = currentPlayer.getHand().get(cardIndex - 1);
        if (!rules.canPlayCard(chosenCard, getTopCard())) {
            System.out.println("Illegal move!");
            rules.applyPenalty(currentPlayer, deckManager);
            return;
        }

        discardPile.add(chosenCard);
        currentPlayer.playCard(cardIndex - 1);

        Action action = chosenCard.getAction();
        if (action != null) {
            action.apply(this);
        }
    }


    public void endGame(Player winner) {
        System.out.println(winner.getName() + " has won the game!");
    }

    public Card getTopCard() {
        if (discardPile.isEmpty()) {
            throw new IllegalStateException("The discard pile is empty!");
        }
        return discardPile.get(discardPile.size() - 1);
    }

    public void setInitialTopCard(Card topCard) {
        discardPile.add(topCard);
    }

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public DeckManager getDeckManager() {
        return deckManager;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public ColorSelector getColorSelector() {
        return colorSelector;
    }

    private int promptForCardIndex(Player currentPlayer) {
        System.out.println("Choose a card to play (enter the index) or enter 0 to draw a card:");
        while (true) {
            String input = System.console().readLine(); // Use console input instead of Scanner
            try {
                int cardIndex = Integer.parseInt(input);
                if (cardIndex == 0) {
                    return 0;
                } else if (cardIndex > 0 && cardIndex <= currentPlayer.getHand().size()) {
                    return cardIndex; // Valid card index
                } else {
                    System.out.println("Invalid index. Please enter a valid card index or 0 to draw.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}