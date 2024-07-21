package za.ac.cput.service;


import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Booking;
import za.ac.cput.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService implements IBookingServices {
    private BookingRepository bookingRepository;

    @Autowired
    BookingService(BookingRepository repository) {
        this.bookingRepository = repository;
    }


    @Override
    @Transactional
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }
    @Override
    @Transactional
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking read(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Booking> getall() {
        return bookingRepository.findAll();
    }

//    @Transactional(readOnly = true)
//    public Booking getBookingWithAmenities(Long id) {
//        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Booking not found"));
//        Hibernate.initialize(booking.getAmenities());
//        return booking;
//    }
}

