package app.movement;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {
    LEFT(0, -1, 'l', new LeftwardMovementTracker()),
    RIGHT(0, 1, 'r', new RightwardMovementTracker()),
    UP(-1, 0, 'u', new UpwardMovementTracker()),
    DOWN(1, 0, 'd', new DownwardMovementTracker());

    private int x_factor;
    private int y_factor;
    private char value;
    private MovementTracker movementTracker;

    public static Direction getDirection(char value) {
        for(Direction direction: Direction.values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        return null;
    }
}
