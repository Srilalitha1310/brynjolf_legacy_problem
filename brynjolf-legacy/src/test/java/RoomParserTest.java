import app.RoomParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class RoomParserTest {
    private RoomParser roomParser;

    @BeforeEach
    void setUp() {
        roomParser = new RoomParser();
    }

    @Test
    void shouldParseTheGivenRoom() {
        String sampleRoom = ".,.,x\n.,x,.\nx,.,.";
        String[][] expectedRoom = {{".", ".", "x"}, {".", "x", "."}, {"x", ".", "."}};
        Scanner scan = new Scanner(sampleRoom);
        String[][] room = roomParser.parse(scan, 3);
        Assertions.assertArrayEquals(expectedRoom, room);
    }
}
