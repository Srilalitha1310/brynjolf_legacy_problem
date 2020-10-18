public enum Direction {
    UP(-1, 0, 'u'),
    DOWN(1, 0, 'd'),
    LEFT(0, -1, 'l'),
    RIGHT(0, 1, 'r');

    private int x_factor;
    private int y_factor;
    private char value;

    Direction(int x_factor, int y_factor, char value) {
        this.x_factor = x_factor;
        this.y_factor = y_factor;
        this.value = value;
    }

    public static Direction getDirection(char value) {
        for(Direction direction: Direction.values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        return null;
    }

    public int getX_factor() {
        return x_factor;
    }

    public int getY_factor() {
        return y_factor;
    }
}
