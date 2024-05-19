package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Room;
import za.ac.cput.util.Helper;

public class RoomFactory {

    public static Room buildRoom(Integer roomNumber,Long roomTypeId,String name) {
        if (Helper.isNullorEmpty(name) || roomNumber == null || roomTypeId == null) {
            return null;
        }

        return new Room.Builder()
                .setRoomNumber(roomNumber)
                .setRoomTypeId(roomTypeId)
                .setName(name)
                .build();
    }

}
