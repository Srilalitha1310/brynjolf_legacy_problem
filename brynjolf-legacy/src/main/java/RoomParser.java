import java.util.Scanner;

public class RoomParser {
    public String[][] parse(Scanner scan) {
        String[][] room = new String[3][];
        int i=0;
        while(scan.hasNextLine()) {
            room[i] = scan.nextLine().split(",");
            i++;
        }
        return room;
    }
}
