import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        String[][] room = roomParser.parse(sampleRoom);
        Assertions.assertEquals(expectedRoom[0][0], room[0][0]);
        Assertions.assertEquals(expectedRoom[0][1], room[0][1]);
        Assertions.assertEquals(expectedRoom[0][2], room[0][2]);

        Assertions.assertEquals(expectedRoom[1][0], room[1][0]);
        Assertions.assertEquals(expectedRoom[1][1], room[1][1]);
        Assertions.assertEquals(expectedRoom[1][2], room[1][2]);

        Assertions.assertEquals(expectedRoom[2][0], room[2][0]);
        Assertions.assertEquals(expectedRoom[2][1], room[2][1]);
        Assertions.assertEquals(expectedRoom[2][2], room[2][2]);
    }
}
