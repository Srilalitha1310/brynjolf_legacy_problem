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

    public List<String> getTraversableElements() {
        if (this.equals(BRYNJOLF)) {
            return List.of(Element.EMPTY_SPACE.getId(), Element.EXIT.getId());
        }
        return List.of(Element.EMPTY_SPACE.getId());
    }
}
