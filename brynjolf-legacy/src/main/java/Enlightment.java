import app.GameState;
import app.Navigator;
import app.PathTracker;
import app.RoomParser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Enlightment {
    public static void main(String args[]) throws FileNotFoundException {
        String[][] room = new RoomParser().getRoom();
        String input = getInput();
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

    private static String getInput() {
        System.out.println("Enter the move sequence");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
