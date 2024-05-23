package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;

import java.util.List;

public interface IBookingServices extends IService<Booking, Long> {
    List<Booking> getall();
}
