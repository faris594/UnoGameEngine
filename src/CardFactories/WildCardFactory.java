package CardFactories;

import Actions.WildCardRegistry;
import Actions.interfaces.Action;
import CardFactories.interfaces.CardFactory;
import Cards.Card;
import Cards.WildCard;
import Cards.enums.WildType;

public class WildCardFactory implements CardFactory {
    private final WildType wildType;
    private final WildCardRegistry wildCardRegistry;

    public WildCardFactory(WildType wildType, WildCardRegistry wildCardRegistry) {
        this.wildType = wildType;
        this.wildCardRegistry = wildCardRegistry;
    }

    @Override
    public Card createCard() {
        Action cardAction = wildCardRegistry.getActionForWildType(wildType);
        return new WildCard(wildType, cardAction);
    }
}
