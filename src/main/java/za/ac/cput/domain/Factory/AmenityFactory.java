package za.ac.cput.domain.Factory;
import za.ac.cput.domain.Amenity;
import za.ac.cput.util.Helper;
import java.util.Date;

public class AmenityFactory {

    public static Amenity buildAmenity(String amenityId, String amenityName, String amenityDescription, boolean available, String costId, String inventoryId, String costDescription, Double amount, Date dateIncurred){
        if(Helper.isNullorEmpty(amenityId)||
        Helper.isNullorEmpty(amenityName)||
        Helper.isNullorEmpty(amenityDescription)||
        Helper.isNullorEmpty(costId))
           return null;
        if((amount == 0) && (available == true))
            return null;
        return new Amenity.Builder().setAmenityId(amenityId)
                .setAmenityDescription(amenityDescription)
                .setAmenityName(amenityName)
                .setAvailable(available)
                .build();
    }

    public static Amenity buildAmenity() {
        return null;
    }
}
