package app.movement;

import app.Coordinates;
import app.GameState;
import app.Navigator;
import app.PathTracker;

import java.util.List;

import static app.Constants.ENLIGHTMENT_MAX_MOVE_COUNT;

public abstract class MovementTracker {
    public boolean makeMovement(String[][] room,
                                 String path,
                                 boolean condition,
                                 Direction direction,
                                 PathTracker pathTracker,
                                 List<String> canGo) {
        String tempPath = path;
        Navigator navigator = pathTracker.getNavigator();
        if (condition) {
            tempPath = tempPath.concat(String.valueOf(direction.getValue()));
            navigator.initiateNavigation(room, tempPath, ENLIGHTMENT_MAX_MOVE_COUNT);
            if (!navigator.getGameState().equals(GameState.LOST)) {
                pathTracker.setGameState();
                canGo.add(String.valueOf(direction.getValue()));
            }
        }
        return GameState.WON.equals(navigator.getGameState());
    }

    public abstract boolean isWonByMove(String[][] room,
                                        String path,
                                        PathTracker pathTracker,
                                        Coordinates brynjolfCoordinates,
                                        Coordinates exitCoordinates,
                                        List<String> canGo);
}
