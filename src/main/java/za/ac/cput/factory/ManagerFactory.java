//https://github.com/sitgi/g23-boutique
package za.ac.cput.factory;

import za.ac.cput.domain.Manager;
import za.ac.cput.domain.Staff;

import java.util.Set;

public class ManagerFactory {

    public static Manager createManager(int managerId, String username, String password, Set<Staff> staff) {
        return new Manager.Builder()
                .setManagerId(managerId)
                .setUsername(username)
                .setPassword(password)
                .setStaff(staff)
                .build();
    }
}
