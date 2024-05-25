package za.ac.cput.service;

import za.ac.cput.domain.Room;

import java.util.List;

public interface IRoomService extends IService<Room, Long> {
    List<Room> getall();

}
