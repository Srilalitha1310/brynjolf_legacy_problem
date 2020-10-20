package app.exception;

import app.Constants;

public class RoomLengthExceededException extends RuntimeException {
    public RoomLengthExceededException() {
        super("Room length exceeds " + Constants.MAX_ALLOWED_ROOM_LENGTH);
    }
}
