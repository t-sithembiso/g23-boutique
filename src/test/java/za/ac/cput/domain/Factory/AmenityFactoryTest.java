package za.ac.cput.domain.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Amenity;

import static org.junit.jupiter.api.Assertions.*;

class AmenityFactoryTest {

    @Test
    void buildAmenity(){
        Amenity amenity = AmenityFactory.buildAmenity("A001", "", "Description", "C001", "INV001");
        assertNull(amenity);
    }
}