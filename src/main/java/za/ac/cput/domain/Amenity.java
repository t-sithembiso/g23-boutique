package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
    public class Amenity {
        @Id
        private long amenityId;
        private String amenityName;
        private String amenityDescription;
        private boolean available;
        @ManyToMany(mappedBy = "amenities", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        Set<Booking> bookings = new HashSet<>();

    public Amenity() {

    }

    public Amenity(Builder builder) {
        this.amenityId = builder.amenityId;
        this.amenityName = builder.amenityName;
        this.amenityDescription = builder.amenityDescription;
        this.available = builder.available;
    }

    public long getAmenityId() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amenity amenity)) return false;
        return getAmenityId() == amenity.getAmenityId() && isAvailable() == amenity.isAvailable() && Objects.equals(getAmenityName(), amenity.getAmenityName()) && Objects.equals(getAmenityDescription(), amenity.getAmenityDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmenityId(), getAmenityName(), getAmenityDescription(), isAvailable());
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityId=" + amenityId +
                ", amenityName='" + amenityName + '\'' +
                ", amenityDescription='" + amenityDescription + '\'' +
                ", available=" + available +
                '}';
    }

    public static class Builder {
        private long amenityId;
        private String amenityName;
        private String amenityDescription;
        private boolean available;

        public Builder setAmenityId(long amenityId) {
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
