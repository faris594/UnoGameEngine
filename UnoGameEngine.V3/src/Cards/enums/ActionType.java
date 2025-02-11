package Cards.enums;

public enum ActionType {
    REVERSE("Reverse"),
    SKIP("Skip"),
    DRAWTWO("Draw Two");

    private final String displayName;

    ActionType(String displayName){
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}