package za.ac.cput.service;

import za.ac.cput.domain.RoomType;

import java.util.List;

public interface IRoomTypeService extends IService<RoomType,Long>{
    List<RoomType> getall();
}
