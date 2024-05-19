package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.Objects;

@Entity
public class Amenity extends Cost {
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
    @JoinColumn(name = "booked")
    private Booking booking;

    protected Amenity() {}

    public Amenity(Builder builder) {
        this.amenityId = builder.amenityId;
        this.amenityName = builder.amenityName;
        this.amenityDescription = builder.amenityDescription;
        this.available = builder.available;
        this.costId = builder.costId;
        this.inventoryId = builder.inventoryId;
        this.costDescription =builder.costDescription;
        this.amount = builder.amount;
        this.dateIncurred = builder.dateIncurred;

    }
    public String getAmenityId() {return amenityId;}

    public String getAmenityName() {return amenityName;}

    public String getAmenityDescription() {return amenityDescription;}

    public boolean isAvailable() {return available;}

    public String getCostId() {return costId;}

    public String getInventoryId() {return inventoryId;}

    public String getCostDescription() {return costDescription;}

    public Double getAmount() {return amount;}

    public Date getDateIncurred() {return dateIncurred;}

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
        public String costDescription;
        public String inventoryId;
        public String costId;
        public Double amount;
        public Date dateIncurred;
        private String amenityId;
        private String amenityName;
        private String amenityDescription;
        private boolean available;
        private Booking booking;


        public Builder setCostDescription(String costDescription) {
            this.costDescription = costDescription;
            return this;
        }

        public Builder setInventoryId(String inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }
        public Builder setCostId(String costId) {
            this.costId = costId;
            return this;
        }
        public Builder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }
        public Builder setDateIncurred(Date dateIncurred) {
            this.dateIncurred = dateIncurred;
            return this;
        }
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
            this.inventoryId = amenity.inventoryId;
            this.amount = amenity.amount;
            this.costId = amenity.costId;
            this.costDescription = amenity.costDescription;
            this.dateIncurred = amenity.dateIncurred;
            return this;
        }
        public Amenity build() {
            return new Amenity(this);
        }
    }
}
