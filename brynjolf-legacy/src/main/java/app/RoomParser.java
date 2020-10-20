package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

import static app.Constants.*;

public class RoomParser {
    public String[][] getRoom() throws FileNotFoundException {
        URL file = getClass().getClassLoader().getResource(FILE_NAME);
        Scanner scan = new Scanner(new FileReader(file.getFile()));
        return this.parse(scan, ROOM_LENGTH);
    }

    public String[][] parse(Scanner scan, int length) {
        String[][] room = new String[length][];
        int i=0;
        while(scan.hasNextLine()) {
            room[i] = scan.nextLine().split(ROOM_ELEMENT_DELIMITER);
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
}
