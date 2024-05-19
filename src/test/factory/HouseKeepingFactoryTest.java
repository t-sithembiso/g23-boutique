package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Housekeeping;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HouseKeepingFactoryTest {
    LocalTime timeStarted = LocalTime.of(8, 30);
    LocalTime timeCompleted=LocalTime.of(9, 0);
    @Test
    void buildHouseKeeping() {
        Housekeeping hs= HouseKeepingFactory.buildHouseKeeping(111L,101,"change sheets", "have to change to staffID",
"completed",timeStarted,timeCompleted,"Ready for use");
        assertNotNull(hs);
        System.out.println(hs.toString());
    }
}