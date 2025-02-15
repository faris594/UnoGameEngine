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
        addNumberedCards(cards);
        addActionCards(cards);
        addWildCards(cards);
        return new Deck(cards);
    }


    private void addNumberedCards(List<Card> cards) {
        for (CardColor color : CardColor.values()) {
            if (color != CardColor.WILD) {
                cards.add(new NumberedCardFactory(color, 0).createCard());
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
                for (ActionType action : ActionType.values()) {
                    cards.add(new ActionCardFactory(color, action, actionRegistry).createCard());
                    cards.add(new ActionCardFactory(color, action, actionRegistry).createCard());
                }
            }
        }
    }

    private void addWildCards(List<Card> cards) {
        for (WildType wildType : WildType.values()) {
            WildCardFactory wildCardFactory = new WildCardFactory(wildType, wildCardRegistry);
            for (int i = 0; i < 4; i++) {
                cards.add(wildCardFactory.createCard());
            }
        }
    }
}