package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Guest;
import za.ac.cput.factory.GuestFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class GuestServiceTest {
    @Autowired
    private GuestService guestService;
    private static Guest guest1;
    private static Guest guest2;
    @BeforeAll
    static void setup() {
        guest1 = GuestFactory.buildGuest(234L, "Samson Shabangu", "ShanguSam@gmail.com", "081927396");
        guest2 = GuestFactory.buildGuest(235L, "Sarah Johnson", "sarahjohnson@gmail.com", "082356981");
    }
    @Test
    void a_create() {
        Guest guestCreated1 = guestService.create(guest1);
        assertNotNull(guestCreated1);
        System.out.println(guestCreated1);
        Guest guestCreated2 = guestService.create(guest2);
        assertNotNull(guestCreated2);
        System.out.println(guestCreated2);
    }

    @Test
    void b_update() {
        Guest upGuest =new  Guest.Builder().copy(guest1).setGuestFullName("Sarafinna").build();
        assertNotNull(upGuest);
        System.out.println(upGuest);
        Guest updatedGuest = guestService.update(guest1);
        assertNotNull(updatedGuest);
        System.out.println(updatedGuest);
    }

    @Test
    void c_read() {
        Guest read = guestService.read(guest1.getGuestId());
        assertNotNull(read);
        System.out.println(read);

    }

    @Test
    void d_getall() {
        System.out.println(guestService.getall());
    }
}