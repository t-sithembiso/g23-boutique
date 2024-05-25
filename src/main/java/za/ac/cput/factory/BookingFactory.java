package za.ac.cput.factory;

import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class BookingFactory {
    public static Booking buildBooking(long booking, LocalDate checkIn, LocalDate checkOut, double totalPrice, Guest guest, Amenity amenity, Payment payment){
        if(booking <0
            || checkIn ==null
            || checkOut == null
            || totalPrice <0
            || guest == null
            || amenity == null
            || payment == null)
            return null;
        return new Booking.Builder()
                .setBookingId(booking)
                .setCheckIn(checkIn)
                .setCheckOut(checkOut)
                .setGuest(guest)
                .setAmenities((List<Amenity>) amenity)
                .setPayments((List<Payment>) payment)
                .build();
    }
}
