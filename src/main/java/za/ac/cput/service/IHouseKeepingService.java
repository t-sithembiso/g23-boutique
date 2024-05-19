package za.ac.cput.service;

import za.ac.cput.domain.Housekeeping;

import java.util.List;


public interface IHouseKeepingService extends IService<Housekeeping,Long>{

    List<Housekeeping> getall();
}
