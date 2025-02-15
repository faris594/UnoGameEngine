package Setup;

import Actions.*;
import Cards.enums.ActionType;
import Cards.enums.WildType;
import Deck.StandardUnoDeckFactory;
import Deck.interfaces.DeckFactory;
import Managers.StandardDeckManager;
import Managers.StandardTurnManager;
import Managers.interfaces.DeckManager;
import Managers.interfaces.TurnManager;
import Rules.StandardCardLegality;
import Rules.StandardGameOverCondition;
import Rules.StandardPenalty;
import Rules.StandardRules;
import Rules.interfaces.Rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSetupFactory {
    public static GameManager createGameManager(Scanner scanner) {
        // Step 1: Get the number of players and their names
        System.out.println("Enter the number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter the name of Player " + i + ":");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }

        // Step 2: Initialize the rules
        Rules ruleSet = new StandardRules(
                new StandardCardLegality(),
                new StandardPenalty(),
                new StandardGameOverCondition()
        );

        // Step 3: Initialize the card registries
        ActionRegistry actionRegistry = new ActionRegistry();
        actionRegistry.registerAction(ActionType.SKIP, SkipAction::new);
        actionRegistry.registerAction(ActionType.REVERSE, ReverseAction::new);
        actionRegistry.registerAction(ActionType.DRAWTWO, DrawTwoAction::new);

        WildCardRegistry wildCardRegistry = new WildCardRegistry();
        wildCardRegistry.registerAction(WildType.WILD, WildChangeColorAction::new);
        wildCardRegistry.registerAction(WildType.WILD_DRAW_FOUR, WildDrawFourAction::new);

        // Step 5: Create the deck factory with both registries
        DeckFactory deckFactory = new StandardUnoDeckFactory(actionRegistry, wildCardRegistry);

        // Step 6: Set up the game with the initial hand size
        int initialHandSize = 7;
        StandardUnoGame standardUnoGame = new StandardUnoGame(players, ruleSet, deckFactory, initialHandSize);
        standardUnoGame.setup();

        // Step 7: Initialize the managers
        DeckManager deckManager = new StandardDeckManager(standardUnoGame.getDeck());
        TurnManager turnManager = new StandardTurnManager(players);

        // Step 8: Create and return the GameManager
        GameManager gameManager = GameManager.getInstance(deckManager, turnManager, ruleSet, players);
        gameManager.setInitialTopCard(standardUnoGame.getDiscardPile().get(0));
        return gameManager;
    }
}