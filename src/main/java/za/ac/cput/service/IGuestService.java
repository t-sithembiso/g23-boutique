package za.ac.cput.service;

import za.ac.cput.domain.Guest;

import java.util.List;

public interface IGuestService extends IService<Guest, Long>{
    List<Guest>getall();
//    void delete(long Id);
}
