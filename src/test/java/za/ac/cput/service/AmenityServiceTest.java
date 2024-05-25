package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Amenity;
import za.ac.cput.factory.AmenityFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AmenityServiceTest {
    @Autowired
    private AmenityService amenityService;
    private static Amenity amenity1;
    private static Amenity amenity2;

    @BeforeAll
    static void setup() {
        amenity1 = AmenityFactory.buildAmenity(12L, "Swimming pool", "Pool Available from 9am - 6pm", true);
        amenity2 = AmenityFactory.buildAmenity(13L, "Gym", "Open 24 hours", true);
    }
    @Test
    void a_create() {
        Amenity amenityCreated1 = amenityService.create(amenity1);
        assertNotNull(amenityCreated1);
        System.out.println(amenityCreated1);
        Amenity amenitycreated2 = amenityService.create(amenity2);
        assertNotNull(amenitycreated2);
        System.out.println(amenitycreated2);
    }

    @Test
    void b_update() {
        Amenity updateAmenity =new  Amenity.Builder().copy(amenity2).setAmenityName("Gym Fitness").build();
        assertNotNull(updateAmenity);
        Amenity update = amenityService.update(updateAmenity);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    void c_read() {
        Amenity read = amenityService.read(amenity2.getAmenityId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_getall() {
        System.out.println(amenityService.getall());
    }
}