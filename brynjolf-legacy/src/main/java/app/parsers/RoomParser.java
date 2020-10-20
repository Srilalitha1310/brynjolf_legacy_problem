package app.parsers;

import app.exception.RoomLengthExceededException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

import static app.Constants.*;

public class RoomParser {
    public String[][] getRoom() throws FileNotFoundException {
        URL file = getClass().getClassLoader().getResource(FILE_NAME);
        int roomLength = findRoomLength(getScanner(file));
        return this.parse(getScanner(file), roomLength);
    }

    public int findRoomLength(Scanner scan) {
        int length = scan.nextLine().split(ROOM_ELEMENTS_DELIMITER).length;
        if (length <= MAX_ALLOWED_ROOM_LENGTH) {
            return length;
        }
        throw new RoomLengthExceededException();
    }

    public String[][] parse(Scanner scan, int length) {
        String[][] room = new String[length][];
        int i=0;
        while(scan.hasNextLine()) {
            room[i] = scan.nextLine().split(ROOM_ELEMENTS_DELIMITER);
            i++;
        }
        System.out.println("The given room:");
        printRoom(room);
        return room;
    }

    public void printRoom(String[][] room) {
        for (String[] strings : room) {
            for (int column = 0; column < room[0].length; column++) {
                System.out.print(strings[column] + "\t");
            }
            System.out.println();
        }
    }

    private Scanner getScanner(URL file) throws FileNotFoundException {
        return new Scanner(new FileReader(file.getFile()));
    }
}
