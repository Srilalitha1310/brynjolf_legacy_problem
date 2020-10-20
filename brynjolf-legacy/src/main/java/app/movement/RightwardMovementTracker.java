package app.movement;

import app.Coordinates;
import app.PathTracker;

import java.util.List;

public class RightwardMovementTracker extends MovementTracker {
    public boolean isWonByMove(String[][] room,
                               String path,
                               PathTracker pathTracker,
                               Coordinates brynjolfCoordinates,
                               Coordinates exitCoordinates,
                               List<String> canGo) {
        boolean condition = brynjolfCoordinates.getY() < exitCoordinates.getY();
        return super.makeMovement(room, path, condition, Direction.RIGHT, pathTracker, canGo);
    }
}
