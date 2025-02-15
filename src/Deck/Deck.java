package Deck;

import Cards.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public Deck(List<Card> initialCards) {
        this.cards = new ArrayList<>(initialCards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addAllCards(List<Card> cardsToAdd) {
        cards.addAll(cardsToAdd);
    }

    public void shuffle() {
        for (int i = 0; i < 7; i++) {
            Collections.shuffle(cards);
        }
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The deck is empty!");
        }
        return cards.remove(0);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }


}