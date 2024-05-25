package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    private final RoomRepository repository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }
    @Override
    public Room create(Room room) {
        return repository.save(room);
    }
    @Override
    public Room read(Long roomTypeId) {
        return repository.findById(roomTypeId).orElse(null);
    }
    @Override
    public Room update(Room room) {
        return repository.save(room);
    }

    @Override
    public List<Room> getall() {
        return repository.findAll();
    }
}