package za.ac.cput.factory;

import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Booking;
import za.ac.cput.util.Helper;

import java.util.List;

public class AmenityFactory {
    public static Amenity buildAmenity(long amenityId, String amenityName, String amenityDescription, boolean available){
        if(amenityId== 0 || Helper.isNullorEmpty(amenityName) || Helper.isNullorEmpty(amenityDescription)
                || Helper.isNull(available) )
            return null;
        return new Amenity.Builder().setAmenityId(amenityId)
                .setAmenityName(amenityName)
                .setAmenityDescription(amenityDescription)
                .setAvailable(available)
                .build();
    }

}

