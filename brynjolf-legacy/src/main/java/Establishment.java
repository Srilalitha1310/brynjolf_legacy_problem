import app.Navigator;
import app.RoomParser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Establishment {
    public static void main(String args[]) throws FileNotFoundException {
        String[][] room = new RoomParser().getRoom();
        String input = getInput();
        getResult(room, input);
    }

    private static void getResult(String[][] room, String input) {
        Navigator navigator = new Navigator();
        String[][] result = navigator.initiateNavigation(room, input, 4);
        System.out.println("The resulting room :");
        new RoomParser().printRoom(result);
        System.out.println(String.format("%s : Executed %d moves out of %d", navigator.getGameState(),
                navigator.getMoveCount(), input.length()));
    }

    private static String getInput() {
        System.out.println("Enter the move sequence");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
