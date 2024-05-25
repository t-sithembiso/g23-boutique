package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Room {
    @Id
    private long roomNumber;
    @ManyToOne
    @JoinColumn(name = "roomType")
    private RoomType roomType;
    protected Room() {

    }
    private Room(Builder builder){
        this.roomNumber = builder.roomNumber;
        this.roomType = builder.roomType;

    }


    public long getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return getRoomNumber() == room.getRoomNumber() && Objects.equals(getRoomType(), room.getRoomType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber(), getRoomType());
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                '}';
    }

    public static class Builder {
        private long roomNumber;
        private RoomType roomType;

        public Builder setRoomNumber(long roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setRoomType(RoomType roomType) {
            this.roomType = roomType;
            return this;
        }

        public Room.Builder copy(Room room){
            this.roomNumber = room.roomNumber;
            this.roomType = room.roomType;
            return this;
        }
        public Room build(){
            return new Room(this);
        }
    }
}

