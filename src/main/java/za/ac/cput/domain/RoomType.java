package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class RoomType{
    @Id
    private Long roomTypeId;
    private String roomDescription;
    private Integer numberOfBeds;
    private Double pricePerNight;
    @ManyToOne
    @JoinColumn(name = "roomNumber")
    private Room room;

    protected RoomType() {
    }

    private RoomType(Builder builder) {
        this.roomTypeId = builder.roomTypeId;
        this.roomDescription = builder.roomDescription;
        this.numberOfBeds = builder.numberOfBeds;
        this.pricePerNight = builder.pricePerNight;
        this.room = builder.room;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomType roomType)) return false;
        return Objects.equals(getRoomTypeId(), roomType.getRoomTypeId()) && Objects.equals(getRoomDescription(), roomType.getRoomDescription()) && Objects.equals(getNumberOfBeds(), roomType.getNumberOfBeds()) && Objects.equals(getPricePerNight(), roomType.getPricePerNight()) && Objects.equals(getRoom(), roomType.getRoom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomTypeId(), getRoomDescription(), getNumberOfBeds(), getPricePerNight(), getRoom());
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", roomDescription='" + roomDescription + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                ", pricePerNight=" + pricePerNight +
                ", room=" + room +
                '}';
    }

    public static class Builder {
        private Long roomTypeId;
        private String roomDescription;
        private Integer numberOfBeds;
        private Double pricePerNight;

        private Room room;

        public void setRoomTypeId(Long roomTypeId) {
            this.roomTypeId = roomTypeId;
        }

        public void setRoomDescription(String roomDescription) {
            this.roomDescription = roomDescription;
        }

        public void setNumberOfBeds(Integer numberOfBeds) {
            this.numberOfBeds = numberOfBeds;
        }

        public void setPricePerNight(Double pricePerNight) {
            this.pricePerNight = pricePerNight;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public Builder Copy(RoomType roomType){
            this.roomTypeId = roomType.roomTypeId;
            this.roomDescription = roomType.roomDescription;
            this.numberOfBeds = roomType.numberOfBeds;
            this.pricePerNight = roomType.pricePerNight;
            this.room = roomType.room;
            return this;
        }
        public RoomType build(){
            return new RoomType();
        }

    }
}

