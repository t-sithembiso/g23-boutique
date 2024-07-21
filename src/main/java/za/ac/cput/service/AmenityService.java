package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Amenity;
import za.ac.cput.repository.AmenityRepository;

import java.util.List;
@Service
public class AmenityService implements IAmenityService {
    private final AmenityRepository amenityRepository;
    @Autowired
    AmenityService(AmenityRepository amenityRepository){
        this.amenityRepository = amenityRepository;
    }
    @Override
    @Transactional
    public Amenity create(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    @Override
    @Transactional
    public Amenity update(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    @Override
    @Transactional(readOnly = true)
    public Amenity read(Long id) {
        return amenityRepository.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Amenity> getall() {
        return amenityRepository.findAll();
    }
}
