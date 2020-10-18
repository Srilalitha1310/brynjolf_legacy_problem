import java.util.List;

public class Navigator {

    private GameState gameState;

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
        while (true) {
            int tempX = x + direction.getX_factor();
            int tempY = y + direction.getY_factor();
            if (isOutOfIndex(threshold, tempX, tempY)) break;
            if (changeGameState(room, element, x, y, room[tempX][tempY])) break;
            room[x][y] = Element.EMPTY_SPACE.getId();
            x = tempX;
            y = tempY;
            room[x][y] = element.getId();
        }
    }

    private boolean changeGameState(String[][] room, Element element, int x, int y, String anObject) {
        if (!Element.EMPTY_SPACE.getId().equals(anObject)) {
            setGameState(element, x, y, room, anObject);
            return true;
        }
        return false;
    }

    private boolean isOutOfIndex(int threshold, int tempX, int tempY) {
        return (tempX < 0 || tempY < 0) || (tempX > threshold || tempY > threshold);
    }

    private void setGameState(Element element, int x, int y, String[][] room, String neighbourElement) {
        if (element.isOnExit(neighbourElement)) {
            room[x][y] = Element.EMPTY_SPACE.getId();
            this.gameState = GameState.WON;
            return;
        }
        if (element.isCaught(neighbourElement)) {
            room[x][y] = Element.SECURITY_GUARD.getId();
            this.gameState = GameState.WON;
        }
    }

    public GameState getGameState() {
        return this.gameState;
    }
}
