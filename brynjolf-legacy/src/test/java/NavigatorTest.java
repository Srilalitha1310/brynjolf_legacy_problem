import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NavigatorTest {

    @Test
    void shouldNavigateToLeftInOpenSpace() {
        Navigator navigator = new Navigator();
        String[][] initialRoom = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String[][] expectedRoom = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {"b", ".", ".", "e"},
                {"x", "g", ".", "."}
        };
        String[][] finalRoom = navigator.navigate(initialRoom, Direction.LEFT);
        Assertions.assertArrayEquals(expectedRoom, finalRoom);
    }

    @Test
    void shouldNavigateUpInOpenSpace() {
        Navigator navigator = new Navigator();
        String[][] initialRoom = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String[][] expectedRoom = {
                {"g", "b", "g", "x"},
                {".", ".", ".", "x"},
                {".", ".", ".", "e"},
                {"x", ".", ".", "."}
        };
        String[][] finalRoom = navigator.navigate(initialRoom, Direction.UP);
        Assertions.assertArrayEquals(expectedRoom, finalRoom);
    }

    @Test
    void shouldNavigateDownInOpenSpace() {
        Navigator navigator = new Navigator();
        String[][] initialRoom = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String[][] expectedRoom = {
                {".", ".", ".", "x"},
                {".", ".", ".", "x"},
                {"g", ".", ".", "e"},
                {"x", "b", "g", "."}
        };
        String[][] finalRoom = navigator.navigate(initialRoom, Direction.DOWN);
        Assertions.assertArrayEquals(expectedRoom, finalRoom);
    }

    @Test
    void shouldNavigateToRightInOpenSpaceAndShouldWin() {
        Navigator navigator = new Navigator();
        String[][] initialRoom = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        String[][] expectedRoom = {
                {".", ".", ".", "x"},
                {".", ".", "g", "x"},
                {".", ".", ".", "e"},
                {"x", ".", ".", "g"}
        };
        String[][] finalRoom = navigator.navigate(initialRoom, Direction.RIGHT);
        Assertions.assertArrayEquals(expectedRoom, finalRoom);
        Assertions.assertEquals(GameState.WON, navigator.getGameState());
    }

    @Test
    void shouldNavigateThroughTheFirstFourMovesOfTheGivenInputAndHaveLost() {
        Navigator navigator = new Navigator();
        String[][] initialRoom = {
                {".", "x", ".", "x"},
                {"g", ".", ".", "e"},
                {".", "b", ".", "."},
                {"x", ".", "g", "."}
        };
        String[][] expectedRoom = {
                {"g", "x", ".", "x"},
                {".", "g", ".", "e"},
                {".", ".", ".", "."},
                {"x", ".", ".", "."}
        };
        String input = "ludrr";
        String[][] finalRoom = navigator.initiateNavigation(initialRoom, input);
        Assertions.assertArrayEquals(expectedRoom, finalRoom);
        Assertions.assertEquals(GameState.LOST, navigator.getGameState());
        Assertions.assertEquals(2, navigator.getMoveCount());
    }

    @Test
    void shouldNavigateThroughTheFirstFourMovesOfTheGivenInputAndHaveResultedUndecided() {
        Navigator navigator = new Navigator();
        String[][] initialRoom = {
                {".", "x", ".", "x"},
                {"g", ".", ".", "e"},
                {".", "b", ".", "."},
                {"x", ".", "g", "."}
        };
        String[][] expectedRoom = {
                {"g", "x", "g", "x"},
                {".", "b", ".", "e"},
                {".", ".", ".", "."},
                {"x", ".", ".", "."}
        };
        String input = "uuuuuu";
        String[][] finalRoom = navigator.initiateNavigation(initialRoom, input);
        Assertions.assertArrayEquals(expectedRoom, finalRoom);
        Assertions.assertEquals(GameState.UNDECIDED, navigator.getGameState());
        Assertions.assertEquals(4, navigator.getMoveCount());
    }
}
