package za.ac.cput.factory;

import za.ac.cput.domain.RoomType;
import za.ac.cput.util.Helper;

public class RoomTypeFactory {
    public static RoomType buildRoomType(long roomTypeId, String roomDescription, int numberOfBeds, double pricePerNight){
        if(roomTypeId == 0 || Helper.isNullorEmpty(roomDescription)
            || numberOfBeds == 0 || pricePerNight == 0)
            return null;
            return new RoomType.Builder()
                    .setRoomTypeId(roomTypeId)
                    .setRoomDescription(roomDescription)
                    .setNumberOfBeds(numberOfBeds)
                    .setPricePerNight(pricePerNight)
                    .build();

    }
}
