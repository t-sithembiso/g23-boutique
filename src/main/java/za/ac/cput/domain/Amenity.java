package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amenity amenity = (Amenity) o;
        return available == amenity.available && Objects.equals(amenityId, amenity.amenityId) && Objects.equals(amenityName, amenity.amenityName) && Objects.equals(amenityDescription, amenity.amenityDescription) && Objects.equals(costId, amenity.costId) && Objects.equals(inventoryId, amenity.inventoryId) && Objects.equals(costDescription, amenity.costDescription) && Objects.equals(amount, amenity.amount) && Objects.equals(dateIncurred, amenity.dateIncurred);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amenityId, amenityName, amenityDescription, available, costId, inventoryId, costDescription, amount, dateIncurred);
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityId='" + amenityId + '\'' +
                ", amenityName='" + amenityName + '\'' +
                ", amenityDescription='" + amenityDescription + '\'' +
                ", available=" + available +
                ", costId='" + costId + '\'' +
                ", inventoryId='" + inventoryId + '\'' +
                ", costDescription='" + costDescription + '\'' +
                ", amount=" + amount +
                ", dateIncurred=" + dateIncurred +
                '}';
    }

    public static class Builder {
        private String amenityId;
        private String amenityName;
        private String amenityDescription;
        private boolean available;




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
