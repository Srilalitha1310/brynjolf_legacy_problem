import java.util.List;

public enum Element {
    EMPTY_SPACE("."),
    SECURITY_GUARD("g"),
    EXIT("e"),
    BRYNJOLF("b"),
    WALL("x");

    private String id;

    Element(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isCaught(String neighbourElement) {
        return (this.equals(BRYNJOLF) && neighbourElement.equals(SECURITY_GUARD.getId())) ||
                this.equals(SECURITY_GUARD) && neighbourElement.equals(BRYNJOLF.getId());
    }

    public boolean isOnExit(String neighbourElement) {
        return this.equals(BRYNJOLF) && neighbourElement.equals(EXIT.getId());
    }
}
