import java.util.Scanner;

public class RoomParser {
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
