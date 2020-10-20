import app.Coordinates;
import app.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CoordinatesTest {

    @Test
    void shouldFindBrynjolf() {
        String[][] room = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        Coordinates brynjolfCoordinates = Coordinates.findElement(room, Element.BRYNJOLF);
        Assertions.assertEquals(2, brynjolfCoordinates.getX());
        Assertions.assertEquals(1, brynjolfCoordinates.getY());
    }

    @Test
    void shouldFindGuards() {
        String[][] room = {
                {".", ".", ".", "x"},
                {"g", ".", ".", "x"},
                {".", "b", ".", "e"},
                {"x", ".", "g", "."}
        };
        List<Coordinates> guardsCoordinates = Coordinates.findGuards(room);
        Coordinates guard1 = guardsCoordinates.get(0);
        Coordinates guard2 = guardsCoordinates.get(1);
        Assertions.assertEquals(1, guard1.getX());
        Assertions.assertEquals(0, guard1.getY());
        Assertions.assertEquals(3, guard2.getX());
        Assertions.assertEquals(2, guard2.getY());
    }
}
