package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Locale;
import java.util.Objects;

@Entity
public class Room {
    @Id
    protected Integer roomNumber;
    private Long roomTypeId;
    protected String name;
    public Room() {

    }


    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber) && Objects.equals(roomTypeId, room.roomTypeId) && Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomTypeId, name);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomTypeId=" + roomTypeId +
                ", name='" + name + '\'' +
                '}';
    }

    public Locale.Builder setname(String name) {
        return null;
    }


    public static class Builder {
        public Room setRoomTypeId(Long roomTypeId) {
            return null;
        }

    }
}

