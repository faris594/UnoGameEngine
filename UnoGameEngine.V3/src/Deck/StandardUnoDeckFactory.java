package Deck;

import Actions.ActionRegistry;
import Actions.WildCardRegistry;
import CardFactories.ActionCardFactory;
import CardFactories.NumberedCardFactory;
import CardFactories.WildCardFactory;
import Cards.Card;
import Cards.enums.ActionType;
import Cards.enums.CardColor;
import Cards.enums.WildType;
import Deck.interfaces.DeckFactory;

import java.util.ArrayList;
import java.util.List;

public class StandardUnoDeckFactory implements DeckFactory {
    private final ActionRegistry actionRegistry;
    private final WildCardRegistry wildCardRegistry;

    public StandardUnoDeckFactory(ActionRegistry actionRegistry, WildCardRegistry wildCardRegistry) {
        this.actionRegistry = actionRegistry;
        this.wildCardRegistry = wildCardRegistry;
    }

    @Override
    public Deck createDeck() {
        List<Card> cards = new ArrayList<>();

        // Add numbered cards
        addNumberedCards(cards);

        // Add action cards
        addActionCards(cards);

        // Add wild cards
        addWildCards(cards);

        return new Deck(cards);
    }


    private void addNumberedCards(List<Card> cards) {
        for (CardColor color : CardColor.values()) {
            if (color != CardColor.WILD) {
                // Add one '0' card per color
                cards.add(new NumberedCardFactory(color, 0).createCard());

                // Add two copies of each numbered card (1-9)
                for (int i = 1; i <= 9; i++) {
                    cards.add(new NumberedCardFactory(color, i).createCard());
                    cards.add(new NumberedCardFactory(color, i).createCard());
                }
            }
        }
    }


    private void addActionCards(List<Card> cards) {
        for (CardColor color : CardColor.values()) {
            if (color != CardColor.WILD) {
                // Add two copies of each action card
                for (ActionType action : ActionType.values()) {
                    cards.add(new ActionCardFactory(color, action, actionRegistry).createCard());
                    cards.add(new ActionCardFactory(color, action, actionRegistry).createCard());
                }
            }
        }
    }


    private void addWildCards(List<Card> cards) {
        for (WildType wildType : WildType.values()) {
            // Create a WildCardFactory for the current WildType
            WildCardFactory wildCardFactory = new WildCardFactory(wildType, wildCardRegistry);

            // Add four copies of each wild card
            for (int i = 0; i < 4; i++) {
                cards.add(wildCardFactory.createCard());
            }
        }
    }
}