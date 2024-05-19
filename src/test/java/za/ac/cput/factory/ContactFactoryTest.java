package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Staff;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    private Staff testStaff;

    @BeforeEach
    void setUp() {
        // Set up any necessary test data before each test
        testStaff = new Staff.Builder()
                .setStaffNumber(1)
                .setNationalId(123456789)
                .setStaffName("John")
                .setStaffSurname("Doe")
                .build();
    }

    @Test
    void createContact() {
        // Define test data
        String mobile = "1234567890";
        String email = "test@example.com";

        // Create a Contact using the factory
        Contact contact = ContactFactory.createContact(mobile, email, testStaff);

        // Print the created contact details
        System.out.println("Created Contact: " + contact);

        // Verify that the Contact is not null
        assertNotNull(contact);

        // Verify that the Contact properties are set correctly
        assertEquals(mobile, contact.getMobile());
        assertEquals(email, contact.getEmail());

        // Print assertion results
        System.out.println("Contact Mobile: " + contact.getMobile());
        System.out.println("Contact Email: " + contact.getEmail());
    }
}
