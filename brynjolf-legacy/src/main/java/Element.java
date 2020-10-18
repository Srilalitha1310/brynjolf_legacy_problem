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
}
