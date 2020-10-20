package app;

import app.movement.Direction;
import app.movement.MovementTracker;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PathTracker {
    private GameState gameState;
    private Navigator navigator;

    public String solve(String[][] room, String path) {
        navigator = new Navigator();
        gameState = GameState.UNDECIDED;
        Coordinates brynjolfCoordinates = Coordinates.findElement(room, Element.BRYNJOLF);
        Coordinates exitCoordinates = Coordinates.findElement(room, Element.EXIT);
        String winningPath = findWinningPath(room, path, brynjolfCoordinates, exitCoordinates);
        if (winningPath.equals(path)) {
            gameState = GameState.STUCK;
        }
        return winningPath;
    }

    private String findWinningPath(String[][] room, String path, Coordinates brynjolfCoordinates, Coordinates exitCoordinates) {
        if (gameState.equals(GameState.WON)) {
            return path;
        }
        List<String> canGo = getPossibleNextMoves(room, path, brynjolfCoordinates, exitCoordinates);
        for (String nextCanGo: canGo) {
            path = path.concat(nextCanGo);
            path = findWinningPath(room, path, brynjolfCoordinates, exitCoordinates);
        }
        return path;
    }

    private List<String> getPossibleNextMoves(String[][] room, String path, Coordinates brynjolfCoordinates, Coordinates exitCoordinates) {
        List<String> canGo = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            MovementTracker movementTracker = direction.getMovementTracker();
            if (movementTracker.isWonByMove(room, path, this, brynjolfCoordinates, exitCoordinates, canGo)) {
                return canGo;
            }
        }
        return canGo;
    }


    public void setGameState() {
        gameState = navigator.getGameState();
    }
}
