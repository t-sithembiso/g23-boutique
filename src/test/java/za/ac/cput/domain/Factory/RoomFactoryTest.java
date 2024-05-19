package za.ac.cput.domain.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Room;

import static org.junit.jupiter.api.Assertions.*;

class RoomFactoryTest {

    @Test
    void buildRoom() {

        Room room = RoomFactory.buildRoom(null, null, null);
        assertNull(room);

    }

}