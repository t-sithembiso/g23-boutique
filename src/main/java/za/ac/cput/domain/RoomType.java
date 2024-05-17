package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class RoomType extends Room{
    @Id
    private Long roomTypeId;
    private String roomDescription;
    private Integer numberOfBeds;
    private Double pricePerNight;
    public RoomType(){
        super();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(roomTypeId, roomType.roomTypeId) && Objects.equals(roomDescription, roomType.roomDescription) && Objects.equals(numberOfBeds, roomType.numberOfBeds) && Objects.equals(pricePerNight, roomType.pricePerNight);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomTypeId, roomDescription, numberOfBeds, pricePerNight);
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", roomDescription='" + roomDescription + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                ", pricePerNight=" + pricePerNight +
                ", roomNumber=" + roomNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private Integer roomNumber;
        private Long roomTypeId;
        private String name;
        private String roomDescription;
        private Integer numberOfBeds;
        private Double pricePerNight;

        public Builder setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setRoomTypeId(Long roomTypeId) {
            this.roomTypeId = roomTypeId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRoomDescription(String roomDescription) {
            this.roomDescription = roomDescription;
            return this;
        }

        public Builder setNumberOfBeds(Integer numberOfBeds) {
            this.numberOfBeds = numberOfBeds;
            return this;
        }
        public Builder setpricePerNight(Double pricePerNight) {
            return this;

        }
        public Builder Copy(RoomType roomType){
            this.roomNumber= roomType.roomNumber;
            this.roomTypeId = roomType.roomTypeId;
            this.name = roomType.name;
            this.roomDescription = roomType.roomDescription;
            this.numberOfBeds = roomType.numberOfBeds;
            this.pricePerNight = roomType.pricePerNight;
            return this;
        }
        public RoomType build(){
            return new RoomType();
        }


    }
}

