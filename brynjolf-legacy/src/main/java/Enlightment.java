import app.*;

import java.io.FileNotFoundException;

public class Enlightment {
    public static void main(String args[]) throws FileNotFoundException {
        String[][] room = new RoomParser().getRoom();
        String input = new InputParser().getInput();
        getResult(room, input);
    }

    private static void getResult(String[][] room, String input) {
        PathTracker pathTracker = new PathTracker();
        String winningPath = pathTracker.solve(room, input);
        if (pathTracker.getGameState().equals(GameState.WON)) {
            System.out.println("Win: " + winningPath);
            return;
        }
        System.out.println("Stuck: " + "No way to win");
    }
}
