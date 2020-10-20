package app.movement;

import app.Coordinates;
import app.PathTracker;

import java.util.List;

public class DownwardMovementTracker extends MovementTracker {
    public boolean isWonByMove(String[][] room,
                               String path,
                               PathTracker pathTracker,
                               Coordinates brynjolfCoordinates,
                               Coordinates exitCoordinates,
                               List<String> canGo) {
        boolean condition = brynjolfCoordinates.getX() < exitCoordinates.getX();
        return super.makeMovement(room, path, condition, Direction.DOWN, pathTracker, canGo);
    }
}
