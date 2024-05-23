package za.ac.cput.factory;

import za.ac.cput.domain.Room;
import za.ac.cput.domain.RoomType;

public class RoomFactory {
    public static Room buildRoom(long roomNumber, RoomType roomType){
        if(roomNumber== 0 || roomType == null)
            return null;
        return new Room.Builder()
                .setRoomNumber(roomNumber)
                .setRoomType(roomType)
                .build();
    }
}
