package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.util.Helper;

import java.util.List;

public class GuestFactory {
    public static Guest buildGuest(long guestId, String guestFullName, String guestEmail, String guestMobile){
        if(guestId<0 || Helper.isNullorEmpty(guestFullName) || Helper.isNullorEmpty(guestEmail)
                || Helper.isNullorEmpty(guestMobile))
            return null;
        return new Guest.Builder().setGuestId(guestId)
                .setGuestFullName(guestFullName)
                .setGuestEmail(guestEmail)
                .setGuestMobile(guestMobile)
                .build();
    }

    public static Guest buildGuestPass(long guestId, String guestFullName, String guestEmail, String guestMobile){
        if(guestId<0 || Helper.isNullorEmpty(guestFullName) || Helper.isNullorEmpty(guestEmail)
                || Helper.isNullorEmpty(guestMobile))
            return null;
        return new Guest.Builder().setGuestId(guestId)
                .setGuestFullName(guestEmail)
                .setGuestMobile(guestMobile)
                .build();
    }
}
