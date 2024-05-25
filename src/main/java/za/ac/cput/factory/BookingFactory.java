package za.ac.cput.factory;

import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;

import java.time.LocalDate;
import java.util.Set;

public class BookingFactory {
    public static Booking buildBookingP(long bookingId, LocalDate checkIn, LocalDate checkOut, double totalPrice, Guest guest, Set<Amenity> amenities){
        if(bookingId <0
            || checkIn ==null
            || checkOut == null
            || totalPrice <0
            || guest == null
            || amenities == null)
            return null;
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setCheckIn(checkIn)
                .setCheckOut(checkOut)
                .setGuest(guest)
                .setAmenities(amenities)
                .build();
    }
    public static Booking buildBooking(long bookingId, LocalDate checkIn, LocalDate checkOut, double totalPrice, Guest guest, Set<Amenity> amenities1){
        if(bookingId <0
                || checkIn ==null
                || checkOut == null
                || totalPrice <0
                || guest == null)
            return null;
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setCheckIn(checkIn)
                .setCheckOut(checkOut)
                .setTotalPrice(totalPrice)
                .setGuest(guest)
                .setAmenities(amenities1)
                .build();
    }
}
