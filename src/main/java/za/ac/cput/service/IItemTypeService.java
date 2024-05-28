package za.ac.cput.service;

import za.ac.cput.domain.ItemType;

import java.util.List;

public interface IItemTypeService extends IService<ItemType, Long>{
    List<ItemType> getall();
}
