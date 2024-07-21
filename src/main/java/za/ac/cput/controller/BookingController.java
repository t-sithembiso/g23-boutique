package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Transactional
    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @Transactional
    @PostMapping("/update")
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @Transactional(readOnly = true)
    @GetMapping("/read/{bookingId}")
    public Booking read(@PathVariable Long bookingId) {
        return bookingService.read(bookingId);
    }

    @Transactional(readOnly = true)
    @GetMapping("/getall")
    public List<Booking> getall() {
        return bookingService.getall();
    }
}
