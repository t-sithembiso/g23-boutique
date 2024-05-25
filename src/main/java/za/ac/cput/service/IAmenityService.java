package za.ac.cput.service;

import za.ac.cput.domain.Amenity;

import java.util.List;

public interface IAmenityService extends IService<Amenity, Long> {
    List<Amenity> getall();
}
