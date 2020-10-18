public enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private int x_factor;
    private int y_factor;

    Direction(int x_factor, int y_factor) {
        this.x_factor = x_factor;
        this.y_factor = y_factor;
    }

    public int getX_factor() {
        return x_factor;
    }

    public int getY_factor() {
        return y_factor;
    }
}
