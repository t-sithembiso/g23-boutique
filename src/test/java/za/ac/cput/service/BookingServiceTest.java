package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.factory.AmenityFactory;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.factory.GuestFactory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookingServiceTest {
    @Autowired
    private BookingService bookingService;
    private static Booking booking1;
    private static Booking booking2;
    private static Booking booking3;

    @BeforeAll
    static void setup(){
        Guest guest1 = GuestFactory.buildGuest(234L, "Samson Shabangu", "ShanguSam@gmail.com", "081927396");
        Guest guest2 = GuestFactory.buildGuest(235L, "Sarah Johnson", "sarahjohnson@gmail.com", "082356981");

        Amenity amenity1 = AmenityFactory.buildAmenity(12L, "Swimming pool", "Pool Available from 9am - 6pm", true);
        Amenity amenity2 = AmenityFactory.buildAmenity(13L, "Gym", "Open 24 hours", true);

        Set<Amenity> amenities1 = new HashSet<>();
        amenities1.add(amenity1);
        Set<Amenity> amenities2 = new HashSet<>();
        amenities2.add(amenity2);

        booking1 = BookingFactory.buildBooking(1, LocalDate.now(), LocalDate.of(2024, 5, 29), 200.0, guest1, amenities1);
        booking3 = BookingFactory.buildBooking(3, LocalDate.of(2024, 5,29), LocalDate.of(2024, 6, 4), 250.0, guest1, amenities2);
        booking2 = BookingFactory.buildBooking(2, LocalDate.now(), LocalDate.of(2024, 6, 10), 300.0, guest2, amenities2);
    }


    @Test
    void a_create() {
        Booking createdBooking = bookingService.create(booking1);
        assertNotNull(createdBooking);
        System.out.println(createdBooking);
        Booking createdBooking1 = bookingService.create(booking3);
        assertNotNull(createdBooking1);
        System.out.println(createdBooking1);
        Booking createdBooking2 = bookingService.create(booking2);
        assertNotNull(createdBooking2);
        System.out.println(createdBooking2);
    }

    @Test
    void b_update() {
        Booking bookingUpdate = new Booking.Builder().copy(booking1).setTotalPrice(355).build();
        assertNotNull(bookingUpdate);
        System.out.println(bookingUpdate);
        Booking bookingChanged = bookingService.update(bookingUpdate);
        assertNotNull(bookingChanged);
        System.out.println(bookingChanged);
    }

    @Test
    void c_read() {
        Booking read = bookingService.read(booking1.getBookingId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_getall() {
        System.out.println(bookingService.getall());
    }

}
