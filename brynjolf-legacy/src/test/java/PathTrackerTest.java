import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PathTrackerTest {
    PathTracker pathTracker;

    @BeforeEach
    void setUp() {
        pathTracker = new PathTracker();
    }

    @Test
    void shouldFindPathToExitForTheGivenRoom() {
        String[][] room = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "");
        Assertions.assertEquals("r", path);
        Assertions.assertEquals(GameState.WON, pathTracker.getGameState());
    }

    @Test
    void shouldGetTheWinningMovesWhenInputIsEmpty() {
        String[][] room = {
                {".", "x", ".", "x"},
                {"g", ".", ".", "e"},
                {".", "b", ".", "."},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "");
        Assertions.assertEquals("ru", path);
        Assertions.assertEquals(GameState.WON, pathTracker.getGameState());
    }

    @Test
    void shouldExecuteTheGivenMovesAndPrintTheRest() {
        String[][] room = {
                {".", "x", ".", "x"},
                {"g", ".", ".", "e"},
                {".", "b", ".", "."},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "ududu");
        Assertions.assertEquals("ududur", path);
        Assertions.assertEquals(GameState.WON, pathTracker.getGameState());
    }

    @Test
    void shouldBeStuckOnAWrongMove() {
        String[][] room = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "."},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "d");
        Assertions.assertEquals("d", path);
        Assertions.assertEquals(GameState.STUCK, pathTracker.getGameState());
    }
}
