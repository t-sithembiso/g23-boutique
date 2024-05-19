package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;
@Entity
public class Guest {
    @Id
    private long guestId;
    private String guestFullName;
    private String guestEmail;
    private String guestMobile;

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    protected Guest(){

    }

    public Guest(Builder builder){
        this.guestId = builder.guestId;
        this.guestFullName = builder.guestFullName;
        this.guestEmail = builder.guestEmail;
        this.guestMobile = builder.guestMobile;

    }

    public long getGuestId() {
        return guestId;
    }

    public String getGuestFullName() {
        return guestFullName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public String getGuestMobile() {
        return guestMobile;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest guest)) return false;
        return getGuestId() == guest.getGuestId() && Objects.equals(getGuestFullName(), guest.getGuestFullName()) && Objects.equals(getGuestEmail(), guest.getGuestEmail()) && Objects.equals(getGuestMobile(), guest.getGuestMobile()) && Objects.equals(getBookings(), guest.getBookings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuestId(), getGuestFullName(), getGuestEmail(), getGuestMobile(), getBookings());
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", guestFullName='" + guestFullName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", guestMobile='" + guestMobile + '\'' +
                ", bookings=" + bookings +
                '}';
    }

    public class Builder{
        private long guestId;
        private String guestFullName;
        private String guestEmail;
        private String guestMobile;
        private List<Booking> bookings;

        public Builder setGuestId(long guestId) {
            this.guestId = guestId;
            return this;
        }

        public Builder setGuestFullName(String guestFullName) {
            this.guestFullName = guestFullName;
            return this;
        }

        public Builder setGuestEmail(String guestEmail) {
            this.guestEmail = guestEmail;
            return this;
        }

        public Builder setGuestMobile(String guestMobile) {
            this.guestMobile = guestMobile;
            return this;
        }

        public Builder setBookings(List<Booking> bookings) {
            this.bookings = bookings;
            return this;
        }

        public Guest.Builder copy(Guest guest){
            this.guestId = guest.guestId;
            this.guestFullName = guest.guestFullName;
            this.guestEmail = guest.guestEmail;
            this.guestMobile = guest.guestMobile;
            return this;
        }

        public Guest build(){
            return new Guest(this);
        }
    }
}
