package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Guest;
import za.ac.cput.repository.GuestRepository;

import java.util.List;

@Service
public class GuestService implements IGuestService{
    private GuestRepository guestRepository;
    @Autowired
    GuestService(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }
    @Override
    @Transactional
    public Guest create(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    @Transactional
    public Guest update(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    @Transactional(readOnly = true)
    public Guest read(Long id) {
        return guestRepository.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Guest> getall() {
        return guestRepository.findAll();
    }

//    @Override
//    public void delete(long Id) {
//
//    }
}
