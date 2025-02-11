package Managers;

import Managers.interfaces.TurnManager;
import Setup.Player;

import java.util.List;

public class StandardTurnManager implements TurnManager {
    private final List<Player> players;
    private int currentPlayerIndex;
    private boolean isReversed = false;

    public StandardTurnManager(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0; // Start with the first player
    }

    @Override
    public void nextTurn() {
        if (isReversed) {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    @Override
    public void skipNextPlayer() {
        int nextPlayerIndex;
        if (isReversed) {
            nextPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        } else {
            nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        String nextPlayerName = players.get(nextPlayerIndex).getName();
        System.out.println("Skipping " + nextPlayerName + "'s turn.");
        nextTurn();
    }

    @Override
    public void reverseTurnOrder() {
        System.out.println("Reversing the turn order.");
        isReversed = !isReversed;
    }

    @Override
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}