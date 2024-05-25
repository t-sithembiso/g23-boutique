package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Room;
import za.ac.cput.domain.RoomType;
import za.ac.cput.factory.RoomFactory;
import za.ac.cput.factory.RoomTypeFactory;
import za.ac.cput.repository.RoomRepository;
import java.util.Optional;
import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class RoomServiceTest {
    @Autowired
    private RoomService roomService;
    private static Room room1;
    private static Room room2;
    private static Room room3;
    private static Room room4;
    @BeforeAll
    static void setup() {
        RoomType roomType1 = RoomTypeFactory.buildRoomType(2L, "Single bed with kitchen and ocean view", 2, 350);
        RoomType roomType2 = RoomTypeFactory.buildRoomType(3,"King bed, Balcony, and Ocean View", 1, 600);
        RoomType roomType3 = RoomTypeFactory.buildRoomType(5, "3 bedroom Apartment, 1 bedroom ensuite, 2 double bed", 3, 1250);
        room1 = RoomFactory.buildRoom(1,roomType1);
        room2 = RoomFactory.buildRoom(3,roomType2);
        room3 = RoomFactory.buildRoom(2,roomType1);
        room4 = RoomFactory.buildRoom(4, roomType3);

    }

    @Test
    void a_create() {
        Room created1 = roomService.create(room1);
        assertNotNull(created1);
        System.out.println(created1);
        Room created2 = roomService.create(room2);
        assertNotNull(created2);
        System.out.println(created2);
        Room created3 = roomService.create(room4);
        assertNotNull(created3);
        System.out.println(created3);
        Room created4 = roomService.create(room3);
        assertNotNull(created4);
        System.out.println(created1);
    }

    @Test
    void b_read() {
        Room read = roomService.read(room2.getRoomNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_getall() {
        System.out.println(roomService.getall());
    }
}




