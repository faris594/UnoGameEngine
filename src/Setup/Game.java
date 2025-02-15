package Setup;

import Managers.interfaces.DeckManager;
import Rules.interfaces.Rules;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected DeckManager deckManager;
    protected List<Player> players;
    protected Rules rules;

    public Game(List<Player> players, Rules rules, DeckManager deckManager) {
        this.players = new ArrayList<>(players);
        this.rules = rules;
        this.deckManager = deckManager;
    }

    public void setup() {
        // No setup required by default
    }

    public DeckManager getDeckManager() {
        return deckManager;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
