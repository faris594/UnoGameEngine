package Actions;

import Actions.interfaces.Action;
import Cards.enums.WildType;

import java.util.HashMap;
import java.util.Map;

public class WildCardRegistry {
    private final Map<WildType, Action> wildCardActions = new HashMap<>();

    public WildCardRegistry() {
        // Register default Wild card actions
        registerAction(WildType.WILD, null); // Plain Wild cards don't have an action
        registerAction(WildType.WILD_DRAW_FOUR, new WildDrawFourAction());
    }

    public void registerAction(WildType wildType, Action action) {
        wildCardActions.put(wildType, action);
    }

    public Action getActionForWildType(WildType wildType) {
        Action action = wildCardActions.get(wildType);
        if (action == null && !wildCardActions.containsKey(wildType)) {
            throw new IllegalArgumentException("Unsupported wild type: " + wildType);
        }
        return action;
    }
}