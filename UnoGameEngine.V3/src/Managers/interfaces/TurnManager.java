package Managers.interfaces;

public interface TurnManager {
    void nextTurn();
    void skipNextPlayer();
    void reverseTurnOrder();
    int getCurrentPlayerIndex();
}