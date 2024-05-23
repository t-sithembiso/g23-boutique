package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.RoomType;
import za.ac.cput.repository.ReportRepository;
import za.ac.cput.repository.RoomTypeRepository;

import java.util.List;
@Service
public class RoomTypeService implements IRoomTypeService{
    private final RoomTypeRepository repository;
    @Autowired
    RoomTypeService(RoomTypeRepository repository){
        this.repository = repository;
    }
    @Override
    public RoomType create(RoomType roomType) {
        return repository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType) {
        return repository.save(roomType);
    }

    @Override
    public RoomType read(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public List<RoomType> getall() {
        return repository.findAll();
    }
}
