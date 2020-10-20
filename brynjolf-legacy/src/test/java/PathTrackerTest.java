import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PathTrackerTest {
    @Test
    void shouldFindPathToExitForTheGivenRoom() {
        PathTracker pathTracker = new PathTracker();
        String[][] room = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "");
        Assertions.assertEquals("r", path);
    }

    @Test
    void shouldGetTheWinningMovesWhenInputIsEmpty() {
        PathTracker pathTracker = new PathTracker();
        String[][] room = {
                {".", "x", ".", "x"},
                {"g", ".", ".", "e"},
                {".", "b", ".", "."},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "");
        Assertions.assertEquals("ru", path);
    }

    @Test
    void shouldExecuteTheGivenMovesAndPrintTheRest() {
        PathTracker pathTracker = new PathTracker();
        String[][] room = {
                {".", "x", ".", "x"},
                {"g", ".", ".", "e"},
                {".", "b", ".", "."},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "ududu");
        Assertions.assertEquals("ududur", path);
    }

    @Test
    void shouldBeStuckOnAWrongMove() {
        PathTracker pathTracker = new PathTracker();
        String[][] room = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "."},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String path = pathTracker.solve(room, "d");
        Assertions.assertEquals("d", path);
    }
}
