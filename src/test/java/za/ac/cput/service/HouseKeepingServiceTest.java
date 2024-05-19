package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Housekeeping;
import za.ac.cput.factory.HouseKeepingFactory;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class HouseKeepingServiceTest {
    @Autowired
    private  HouseKeepingService houseKeepingServiceObj;
    private static Housekeeping hs1,hs2;



    @BeforeAll
    static void setup(){
        LocalTime timeStarted = LocalTime.of(8, 30);
        LocalTime timeCompleted=LocalTime.of(9, 0);
        hs1 = HouseKeepingFactory.buildHouseKeeping(111L,101,"change sheets", "have to change to staffID",
                "completed",timeStarted,timeCompleted,"Ready for use");
        assertNotNull(hs1);
        System.out.println(hs1);

        LocalTime timeStarted2 = LocalTime.of(9, 30);
        LocalTime timeCompleted2=LocalTime.of(10, 0);
        hs2 = HouseKeepingFactory.buildHouseKeeping(1678L,108,"refill minibar", "have to change to staffID",
                "completed",timeStarted2,timeCompleted2,"Ready for use");
        assertNotNull(hs2);
        System.out.println(hs2);
    }



    @Test
    void a_create() {

        Housekeeping hsCreated= houseKeepingServiceObj.create(hs1);
        assertNotNull(hsCreated);
        System.out.println(hsCreated.toString());

        Housekeeping hsCreated2= houseKeepingServiceObj.create(hs1);
        assertNotNull(hsCreated2);
        System.out.println(hsCreated2.toString());
    }

    @Test
    void b_update() {
        Housekeeping newHouseKeeping= new Housekeeping.Builder().copy(hs2).setTaskStatus("In progress")
                .build();
        Housekeeping updated= houseKeepingServiceObj.update(newHouseKeeping);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void c_read() {
        Housekeeping read=houseKeepingServiceObj.read(hs1.getTaskId());
        assertNotNull(read);
        System.out.println(read);

        Housekeeping read2=houseKeepingServiceObj.read(hs2.getTaskId());
        assertNotNull(read2);
        System.out.println(read2);

    }
    @Test
    void d_getall() {
        System.out.println(houseKeepingServiceObj.getall());

    }
}