package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Room {
    @Id
    private long roomNumber;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomType> roomType;
    protected Room() {

    }
    private Room(Builder builder){

    }


    public long getRoomNumber() {
        return roomNumber;
    }

    public List<RoomType> getRoomType() {
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
        private List<RoomType> roomType;

        public void setRoomNumber(long roomNumber) {
            this.roomNumber = roomNumber;
        }

        public void setRoomType(List<RoomType> roomType) {
            this.roomType = roomType;
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

