//https://github.com/sitgi/g23-boutique
package za.ac.cput.factory;

import za.ac.cput.domain.Receptionist;
import za.ac.cput.domain.Staff;

import java.util.Set;

public class ReceptionistFactory {

    public static Receptionist createReceptionist(int receptionist_id, String username, String password, Set<Staff> staff) {
        return new Receptionist.Builder()
                .setReceptionist_id(receptionist_id)
                .setUsername(username)
                .setPassword(password)
                .setStaff(staff)
                .build();
    }
}
