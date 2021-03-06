import app.parsers.InputParser;
import app.Navigator;
import app.parsers.RoomParser;

import java.io.FileNotFoundException;

import static app.Constants.ESTABLISHMENT_MAX_MOVE_COUNT;

public class Establishment {
    public static void main(String args[]) throws FileNotFoundException {
        String[][] room = new RoomParser().getRoom();
        String input = new InputParser().getInput();
        play(room, input);
    }

    private static void play(String[][] room, String input) {
        Navigator navigator = new Navigator();
        String[][] result = navigator.initiateNavigation(room, input, ESTABLISHMENT_MAX_MOVE_COUNT);
        System.out.println("The resulting room :");
        new RoomParser().printRoom(result);
        System.out.println(String.format("%s : Executed %d moves out of %d", navigator.getGameState(),
                navigator.getMoveCount(), input.length()));
    }
}
