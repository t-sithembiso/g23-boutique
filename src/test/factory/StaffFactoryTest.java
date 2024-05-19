package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Manager;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.domain.Staff;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StaffFactoryTest {

    private Receptionist testReceptionist;
    private Manager testManager;
    private Set<Contact> testContacts;

    @BeforeEach
    void setUp() {
        // Set up any necessary test data before each test
        testReceptionist = new Receptionist.Builder()
                .setReceptionist_id(1)
                .setUsername("receptionist")
                .setPassword("pass123")
                .setStaff(new HashSet<>())
                .build();

        testManager = new Manager.Builder()
                .setManagerId(1)
                .setUsername("manager")
                .setPassword("pass123")
                .setStaff(new HashSet<>())
                .build();

        testContacts = new HashSet<>();
        testContacts.add(new Contact.Builder()
                .setMobile("1234567890")
                .setEmail("contact@example.com")
                .setStaff(null)
                .build());
    }

    @Test
    void createStaff() {
        // Define test data
        int staffNumber = 1;
        int nationalId = 123456789;
        String staffName = "Okuhle";
        String staffSurname = "Sithole";

        // Create a Staff using the factory
        Staff staff = StaffFactory.createStaff(staffNumber, nationalId, staffName, staffSurname, testContacts, testReceptionist, testManager);

        // Print the created staff details
        System.out.println("Created Staff: " + staff);

        // Verify that the Staff is not null
        assertNotNull(staff);

        // Verify that the Staff properties are set correctly
        assertEquals(staffNumber, staff.getStaffNumber());
        assertEquals(nationalId, staff.getNationalId());
        assertEquals(staffName, staff.getStaffName());
        assertEquals(staffSurname, staff.getStaffSurname());
        assertEquals(testContacts, staff.getContact());
        assertEquals(testReceptionist, staff.getReceptionist());
        assertEquals(testManager, staff.getManager());

        // Print assertion results
        System.out.println("Staff Number: " + staff.getStaffNumber());
        System.out.println("National ID: " + staff.getNationalId());
        System.out.println("Staff Name: " + staff.getStaffName());
        System.out.println("Staff Surname: " + staff.getStaffSurname());
        System.out.println("Staff Contact: " + staff.getContact());
        System.out.println("Staff Receptionist: " + staff.getReceptionist());
        System.out.println("Staff Manager: " + staff.getManager());
    }
}
