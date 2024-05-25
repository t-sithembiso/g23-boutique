package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class RoomType{
    @Id
    private long roomTypeId;
    private String roomDescription;
    private int numberOfBeds;
    private double pricePerNight;
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    private List<Room> room;


    protected RoomType() {
    }

    private RoomType(Builder builder) {
        this.roomTypeId = builder.roomTypeId;
        this.roomDescription = builder.roomDescription;
        this.numberOfBeds = builder.numberOfBeds;
        this.pricePerNight = builder.pricePerNight;
    }

    public long getRoomTypeId() {
        return roomTypeId;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomType roomType)) return false;
        return getRoomTypeId() == roomType.getRoomTypeId() && Objects.equals(getRoomDescription(), roomType.getRoomDescription()) && Objects.equals(getNumberOfBeds(), roomType.getNumberOfBeds()) && Objects.equals(getPricePerNight(), roomType.getPricePerNight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomTypeId(), getRoomDescription(), getNumberOfBeds(), getPricePerNight());
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", roomDescription='" + roomDescription + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

    public static class Builder {
        private long roomTypeId;
        private String roomDescription;
        private int numberOfBeds;
        private double pricePerNight;

        public Builder setRoomTypeId(long roomTypeId) {
            this.roomTypeId = roomTypeId;
            return this;
        }

        public Builder setRoomDescription(String roomDescription) {
            this.roomDescription = roomDescription;
            return this;
        }

        public Builder setNumberOfBeds(int numberOfBeds) {
            this.numberOfBeds = numberOfBeds;
            return this;
        }

        public Builder setPricePerNight(double pricePerNight) {
            this.pricePerNight = pricePerNight;
            return this;
        }

        public Builder Copy(RoomType roomType){
            this.roomTypeId = roomType.roomTypeId;
            this.roomDescription = roomType.roomDescription;
            this.numberOfBeds = roomType.numberOfBeds;
            this.pricePerNight = roomType.pricePerNight;
            return this;
        }
        public RoomType build(){
            return new RoomType(this);
        }

    }
}

