//https://github.com/sitgi/g23-boutique

package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Manager;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.domain.Staff;

import java.util.Set;

public class StaffFactory {

    public static Staff createStaff(int staffNumber, int nationalId, String staffName, String staffSurname, Contact contact, Receptionist receptionist, Manager manager) {
        return new Staff.Builder()
                .setStaffNumber(staffNumber)
                .setNationalId(nationalId)
                .setStaffName(staffName)
                .setStaffSurname(staffSurname)
                .setContact(contact)
                .build();
    }
}
