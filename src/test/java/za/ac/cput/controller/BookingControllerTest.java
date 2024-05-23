package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Report;
import za.ac.cput.factory.AmenityFactory;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.factory.GuestFactory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_Url = "http://localhost:8080/boutique/booking/";
    private static Booking booking1;
    private static Booking booking2;
    private static Guest guest1;
    private static Guest guest2;
    @BeforeAll
    static void setup() {
        guest1 = GuestFactory.buildGuest(110L, "Sbonga Shweni", "shweniSb@gmail.com","0635689923");
        guest2 = GuestFactory.buildGuest(112L, "Sibusiso Kubalo", "SbuKubalo@gmail.com","0838397390");
        Amenity amenity = AmenityFactory.buildAmenity(22,"Game room", "Playstation 5, Nitendo, Xbox X series",true);
        Set<Amenity>amenities = new HashSet<>();
        amenities.add(amenity);
        booking1 = BookingFactory.buildBooking(21, LocalDate.of(2024,8, 21),LocalDate.of(2024,8,25),300, guest1, amenities);
        booking2 = BookingFactory.buildBooking(23, LocalDate.now(), LocalDate.of(2024, 6,1),210,guest2, amenities);
        System.out.println("Success");
    }
    @Test
    void a_create() {
        String url = Base_Url+"create";
        ResponseEntity<Booking> postResponse = restTemplate.postForEntity(url,booking1,Booking.class);
        assertNotNull(postResponse);
        Booking saveBooking = postResponse.getBody();
        assertNotNull(postResponse.getBody());
        ResponseEntity<Booking> postBooking = restTemplate.postForEntity(url,booking2,Booking.class);
        assertNotNull(postBooking);
        Booking saveBook = postBooking.getBody();
        assertNotNull(postBooking.getBody());
        System.out.println(saveBooking);
        System.out.println(saveBook);
    }

    @Test
    void b_update() {
        String url =Base_Url+"update";
        Booking upBooking = new Booking.Builder().copy(booking1).setGuest(guest2).build();
        ResponseEntity<Booking> updated = restTemplate.postForEntity(url,upBooking,Booking.class);
        assertNotNull(updated);
        assertNotNull(updated.getBody());
        System.out.println(updated.getBody());
    }

    @Test
    void c_read() {
        String url = Base_Url+"read/"+ booking2.getBookingId() ;
        ResponseEntity<Booking> read = restTemplate.getForEntity(url, Booking.class);
        assertNotNull(read);
        assertNotNull(read.getBody());
        System.out.println(read.getBody());

    }

    @Test
    void d_getall() {
        String url =Base_Url+"getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Booking> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseAll = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        assertNotNull(responseAll);
        assertNotNull(responseAll.getBody());
        System.out.println(responseAll.getBody());
    }
}