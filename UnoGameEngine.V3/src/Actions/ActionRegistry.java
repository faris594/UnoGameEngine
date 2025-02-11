package Actions;

import Actions.interfaces.Action;
import Cards.enums.ActionType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ActionRegistry {
    private final Map<ActionType, Supplier<Action>> actionMap = new HashMap<>();

    public void registerAction(ActionType actionType, Supplier<Action> actionSupplier) {
        actionMap.put(actionType, actionSupplier);
    }

    public Action createAction(ActionType actionType) {
        Supplier<Action> actionSupplier = actionMap.get(actionType);
        if (actionSupplier == null) {
            throw new IllegalArgumentException("Unsupported action type: " + actionType);
        }
        return actionSupplier.get();
    }
}



