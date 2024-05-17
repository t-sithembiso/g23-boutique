package za.ac.cput.domain;

import java.util.Date;
import java.util.Objects;

public class Booking {
    private Long bookingId;
    private Date checkIn;
    private Date checkOut;

    private double totalPrice;

    protected Booking(){

    }

    private Booking(Builder builder){

    }

    public Long getBookingId() {
        return bookingId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Double.compare(getTotalPrice(), booking.getTotalPrice()) == 0 && Objects.equals(getBookingId(), booking.getBookingId()) && Objects.equals(getCheckIn(), booking.getCheckIn()) && Objects.equals(getCheckOut(), booking.getCheckOut());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCheckIn(), getCheckOut(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static class Builder{
        private Long bookingId;
        private Date checkIn;
        private Date checkOut;

        private double totalPrice;

        public Builder setBookingId(Long bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setCheckIn(Date checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public Builder setCheckOut(Date checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Booking.Builder build(Booking booking){
            this.bookingId = booking.bookingId;
            this.checkIn = booking.checkIn;
            this.checkOut = booking.checkOut;
            this.totalPrice = booking.totalPrice;
            return this;

        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
