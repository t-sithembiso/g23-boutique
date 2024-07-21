//https://github.com/sitgi/g23-boutique
package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Staff;

public class ContactFactory {

    public static Contact createContact(String mobile, String email, Staff staff) {
        return new Contact.Builder()
                .setMobile(mobile)
                .setEmail(email)
                .build();
    }
}
