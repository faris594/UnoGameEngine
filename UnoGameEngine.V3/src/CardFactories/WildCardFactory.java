package CardFactories;

import Actions.interfaces.Action;
import Actions.WildCardRegistry;
import Cards.Card;
import Cards.WildCard;
import Cards.enums.WildType;
import CardFactories.interfaces.CardFactory;

public class WildCardFactory implements CardFactory {
    private final WildType wildType;
    private final WildCardRegistry wildCardRegistry;

    public WildCardFactory(WildType wildType, WildCardRegistry wildCardRegistry) {
        this.wildType = wildType;
        this.wildCardRegistry = wildCardRegistry;
    }

    @Override
    public Card createCard() {
        Action cardAction = wildCardRegistry.getActionForWildType(wildType); // Use the registry to get the action
        return new WildCard(wildType, cardAction); // Create the WildCard with the retrieved action
    }
}