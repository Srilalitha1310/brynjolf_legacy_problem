package app;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static app.Constants.ENLIGHTMENT_MAX_MOVE_COUNT;

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
        if (makeMovement(room,
                path,
                brynjolfCoordinates.getY() > exitCoordinates.getY(),
                Direction.LEFT,
                canGo)) return canGo;
        if (makeMovement(room,
                path,
                brynjolfCoordinates.getY() < exitCoordinates.getY(),
                Direction.RIGHT,
                canGo)) return canGo;
        if (makeMovement(room,
                path,
                brynjolfCoordinates.getX() > exitCoordinates.getX(),
                Direction.UP,
                canGo)) return canGo;
        if (makeMovement(room,
                path,
                brynjolfCoordinates.getX() < exitCoordinates.getX(),
                Direction.DOWN,
                canGo)) return canGo;
        return canGo;
    }

    private boolean makeMovement(String[][] room,
                                 String path,
                                 boolean condition,
                                 Direction direction,
                                 List<String> canGo) {
        String tempPath = path;
        if (condition) {
            tempPath = tempPath.concat(String.valueOf(direction.getValue()));
            navigator.initiateNavigation(room, tempPath, ENLIGHTMENT_MAX_MOVE_COUNT);
            if (navigator.getGameState().equals(GameState.WON)) {
                gameState = navigator.getGameState();
                canGo.add(String.valueOf(direction.getValue()));
                return true;
            }
            if (navigator.getGameState().equals(GameState.UNDECIDED)) {
                gameState = navigator.getGameState();
                canGo.add(String.valueOf(direction.getValue()));
            }
        }
        return false;
    }
}
