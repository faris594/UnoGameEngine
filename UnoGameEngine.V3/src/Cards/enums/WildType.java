package Cards.enums;

public enum WildType {
    WILD("Change Color"),
    WILD_DRAW_FOUR("Draw Four");

    private final String displayName;

    WildType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}