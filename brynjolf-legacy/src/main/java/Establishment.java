import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class Establishment {
    public static void main(String args[]) throws FileNotFoundException {
        String fileName = ("room.txt");
        URL file = Establishment.class.getClassLoader().getResource(fileName);
        Scanner scan = new Scanner(new FileReader(file.getFile()));
        String[][] room = new RoomParser().parse(scan);
    }
}
