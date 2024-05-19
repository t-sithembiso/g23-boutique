package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

    @Entity
    public class Amenity {
        @Id
        private String amenityId;
        private String amenityName;
        private String amenityDescription;
        private boolean available;
        private String costId;
        private String inventoryId;
        private String costDescription;
        private Double amount;
        private Date dateIncurred;
        @ManyToOne
        @JoinColumn(name = "booking_id")
        private Booking booking;

    public Amenity() {

    }

    public Amenity(Builder builder) {
        this.amenityId = builder.amenityId;
        this.amenityName = builder.amenityName;
        this.amenityDescription = builder.amenityDescription;
        this.available = builder.available;

    }

    public String getAmenityId() {
        return amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }
    public String getAmenityDescription() {
        return amenityDescription;
    }
    public boolean isAvailable() {
        return available;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amenity amenity)) return false;
        return isAvailable() == amenity.isAvailable() && Objects.equals(getAmenityId(), amenity.getAmenityId()) && Objects.equals(getAmenityName(), amenity.getAmenityName()) && Objects.equals(getAmenityDescription(), amenity.getAmenityDescription()) && Objects.equals(getBooking(), amenity.getBooking());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmenityId(), getAmenityName(), getAmenityDescription(), isAvailable(), getBooking());
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityId='" + amenityId + '\'' +
                ", amenityName='" + amenityName + '\'' +
                ", amenityDescription='" + amenityDescription + '\'' +
                ", available=" + available +
                ", booking=" + booking +
                '}';
    }

    public static class Builder {
        private String amenityId;
        private String amenityName;
        private String amenityDescription;
        private boolean available;
        private Booking booking;




        public Builder setAmenityId(String amenityId) {
            this.amenityId = amenityId;
            return this;
        }

        public Builder setAmenityName(String amenityName) {
            this.amenityName = amenityName;
            return this;
        }

        public Builder setAmenityDescription(String amenityDescription) {
            this.amenityDescription = amenityDescription;
            return this;
        }

        public Builder setAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder copy(Amenity amenity) {
            this.amenityId = amenity.amenityId;
            this.amenityName = amenity.amenityName;
            this.amenityDescription = amenity.amenityDescription;
            this.available = amenity.available;
            return this;
        }

        public Amenity build() {
            return new Amenity(this);
        }
    }
}
