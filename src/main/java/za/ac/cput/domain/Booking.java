package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Booking {
    @Id
    private Long bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private double totalPrice;
    @ManyToOne
    @JoinTable(name = "guest_id")
    private Guest guest;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Amenity> amenities;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Payment> payments;



    protected Booking(){

    }

    private Booking(Builder builder){
        this.bookingId = builder.bookingId;
        this.checkIn = builder.checkIn;
        this.checkOut = builder.checkOut;
        this.totalPrice = builder.totalPrice;
        this.guest = builder.guest;
        this.amenities = builder.amenities;
        this.payments = builder.payments;

    }

    public Long getBookingId() {
        return bookingId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public Guest getGuest() {
        return guest;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }
    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Double.compare(getTotalPrice(), booking.getTotalPrice()) == 0 && Objects.equals(getBookingId(), booking.getBookingId()) && Objects.equals(getCheckIn(), booking.getCheckIn()) && Objects.equals(getCheckOut(), booking.getCheckOut()) && Objects.equals(getGuest(), booking.getGuest()) && Objects.equals(getAmenities(), booking.getAmenities()) && Objects.equals(getPayments(), booking.getPayments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCheckIn(), getCheckOut(), getTotalPrice(), getGuest(), getAmenities(), getPayments());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", totalPrice=" + totalPrice +
                ", guest=" + guest +
                ", amenities=" + amenities +
                ", payments=" + payments +
                '}';
    }

    public static class Builder{
        private Long bookingId;
        private LocalDate checkIn;
        private LocalDate checkOut;
        private double totalPrice;
        private Guest guest;
        private List<Amenity> amenities;
        private List<Payment> payments;

        public Builder setBookingId(Long bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setCheckIn(LocalDate checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public Builder setCheckOut(LocalDate checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }
        public Builder setGuest(Guest guest) {
            this.guest = guest;
            return this;
        }

        public Builder setAmenities(List<Amenity> amenities) {
            this.amenities = amenities;
            return this;
        }
        public Builder setPayments(List<Payment> payments) {
            this.payments = payments;
            return this;
        }

        public Booking.Builder copy(Booking booking){
            this.bookingId = booking.bookingId;
            this.checkIn = booking.checkIn;
            this.checkOut = booking.checkOut;
            this.totalPrice = booking.totalPrice;
            this.guest = booking.guest;
            this.amenities = booking.amenities;
            this.payments = booking.payments;
            return this;

        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
