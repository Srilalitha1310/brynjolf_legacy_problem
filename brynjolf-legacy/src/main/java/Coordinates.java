import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Coordinates {
    private int x;
    private int y;

    public static Coordinates findBrynjolf(String[][] room) {
        for (int row=0; row < room.length; row++) {
            for (int column=0; column < room[0].length; column++) {
                if (room[row][column].equals(Element.BRYNJOLF.getId())) {
                    return new Coordinates(row, column);
                }
            }
        }
        return null;
    }

    public static List<Coordinates> findGuards(String[][] room) {
        int guardFound = 0;
        List<Coordinates> guardCoordinates = new ArrayList<>();
        for (int row=0; row < room.length && guardFound < 2; row++) {
            for (int column=0; column < room[0].length; column++) {
                if (room[row][column].equals(Element.SECURITY_GUARD.getId())) {
                    guardFound++;
                    guardCoordinates.add(new Coordinates(row, column));
                }
            }
        }
        return guardCoordinates;
    }
}
