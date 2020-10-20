package app;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {
    UP(-1, 0, 'u'),
    DOWN(1, 0, 'd'),
    LEFT(0, -1, 'l'),
    RIGHT(0, 1, 'r');

    private int x_factor;
    private int y_factor;
    private char value;

    public static Direction getDirection(char value) {
        for(Direction direction: Direction.values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        return null;
    }
}
