package za.ac.cput.factory;

import za.ac.cput.domain.Guest;
import za.ac.cput.util.Helper;

public class GuestFactory {
    public static Guest buildGuest(long guestId, long name, long email, long phone){
        if(Helper.isNullorEmpty(Long.parseLong(String.valueOf(guestId)))
        || Helper.isNullorEmpty(name)
        ||Helper.isNullorEmpty(Long.highestOneBit(email)) || Helper.isNullorEmpty(phone))
        return null;

        return new Guest.Builder()
                .setGuestId(guestId)
                .setName(String.valueOf(name))
                .setEmail(String.valueOf(email))
                .setPhone(String.valueOf(phone))
                .build();
    }
}
