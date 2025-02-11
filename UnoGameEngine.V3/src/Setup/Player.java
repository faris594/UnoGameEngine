package Setup;

import Cards.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public void drawCard(Card card) {
        this.hand.add(card);
    }

    public Card playCard(int index) {
        if (index < 0 || index >= hand.size()) {
            throw new IllegalArgumentException("Invalid card index.");
        }
        return this.hand.remove(index);
    }

    public void displayHand() {
        System.out.println(name + "'s hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ": " + hand.get(i));
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}