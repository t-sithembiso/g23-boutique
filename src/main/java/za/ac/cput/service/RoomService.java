package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.RoomRepository;

import java.util.List;

@Service
public final class RoomService implements IRoomService {

    private final RoomRepository repository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Room create(Room room) {
        return repository.save(room);
    }

    public Room read(Long roomTypeId) {
        return (Room) repository.findById(roomTypeId).orElse(null);
    }
    public Room update(Room room) {
        return repository.save(room);
    }
    //try
    public List<Room> getAll() {
        return repository.findAll();
    }
}