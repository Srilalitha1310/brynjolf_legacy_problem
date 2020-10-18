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
    void shouldNavigateToRightInOpenSpace() {
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
                {".", ".", ".", "b"},
                {"x", ".", ".", "g"}
        };
        String[][] finalRoom = navigator.navigate(initialRoom, Direction.RIGHT);
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
}
