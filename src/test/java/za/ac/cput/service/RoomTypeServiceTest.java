package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.RoomType;
import za.ac.cput.factory.RoomTypeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class RoomTypeServiceTest {
    @Autowired
    private RoomTypeService roomTypeService;
    private static RoomType roomType1;
    private static RoomType roomType2;
    private static RoomType roomType3;
    @BeforeAll
    static void setup() {
        roomType1 = RoomTypeFactory.buildRoomType(2L, "Single bed with kitchen and ocean view", 2, 350);
        roomType2 = RoomTypeFactory.buildRoomType(3,"King bed, Balcony, and Ocean View", 1, 600);
        roomType3 = RoomTypeFactory.buildRoomType(5, "3 bedroom Apartment, 1 bedroom ensuite, 2 double bed", 3, 1250);
    }
    @Test
    void a_create() {
        RoomType created1 = roomTypeService.create(roomType1);
        assertNotNull(created1);
        System.out.println(created1);
        RoomType created2 = roomTypeService.create(roomType2);
        assertNotNull(created2);
        System.out.println(created2);
        RoomType created3 = roomTypeService.create(roomType3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_update() {
        RoomType update = new RoomType.Builder().Copy(roomType3)
                .setPricePerNight(1100).build();
        RoomType updatedPrice = roomTypeService.update(update);
        assertNotNull(updatedPrice);
        System.out.println(updatedPrice);
    }

    @Test
    void c_read() {
        RoomType read = roomTypeService.read(roomType2.getRoomTypeId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_getall() {
        System.out.println(roomTypeService.getall());
    }
}