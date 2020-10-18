import java.util.List;

public class Navigator {
    public String[][] navigate(String[][] room, Direction direction) {
        Coordinates brynjolfCoordinates = Coordinates.findBrynjolf(room);
        List<Coordinates> guardCoordinates = Coordinates.findGuards(room);
        move(room, brynjolfCoordinates, Element.BRYNJOLF, direction);
        move(room, guardCoordinates.get(0), Element.SECURITY_GUARD, direction);
        move(room, guardCoordinates.get(1), Element.SECURITY_GUARD, direction);
        return room;
    }

    private void move(String[][] room,
                      Coordinates coordinates,
                      Element element,
                      Direction direction) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        int threshold = room.length - 1;
        List<String> traversableElements = element.getTraversableElements();
        while (true) {
            int tempX = x + direction.getX_factor();
            int tempY = y + direction.getY_factor();
            if ((tempX < 0 || tempY < 0) ||
                    (tempX > threshold || tempY > threshold) ||
                    !traversableElements.contains(room[tempX][tempY])) {
                break;
            }
            room[x][y] = Element.EMPTY_SPACE.getId();
            x = tempX;
            y = tempY;
            room[x][y] = element.getId();
        }
    }
}
