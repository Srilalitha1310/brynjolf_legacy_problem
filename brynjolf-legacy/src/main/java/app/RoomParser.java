package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class RoomParser {
    public String[][] getRoom() throws FileNotFoundException {
        String fileName = ("app/room.txt");
        URL file = getClass().getClassLoader().getResource(fileName);
        Scanner scan = new Scanner(new FileReader(file.getFile()));
        return this.parse(scan, 4);
    }

    public String[][] parse(Scanner scan, int length) {
        String[][] room = new String[length][];
        int i=0;
        while(scan.hasNextLine()) {
            room[i] = scan.nextLine().split(",");
            i++;
        }
        System.out.println("The given room:");
        printRoom(room);
        return room;
    }

    public void printRoom(String[][] room) {
        for (int row = 0; row < room.length; row++){
            for (int column = 0; column < room[0].length; column++){
                System.out.print(room[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
