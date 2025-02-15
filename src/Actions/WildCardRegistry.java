package Actions;

import Actions.interfaces.Action;
import Cards.enums.WildType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WildCardRegistry {
    private final Map<WildType, Supplier<Action>> wildCardActions = new HashMap<>();

    public void registerAction(WildType wildType, Supplier<Action> actionSupplier) {
        wildCardActions.put(wildType, actionSupplier);
    }

    public Action getActionForWildType(WildType wildType) {
        Supplier<Action> actionSupplier = wildCardActions.get(wildType);
        if (actionSupplier == null) {
            throw new IllegalArgumentException("Unsupported wild type: " + wildType);
        }
        return actionSupplier.get();
    }
}
