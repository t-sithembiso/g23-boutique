package za.ac.cput.service;

import za.ac.cput.domain.Cost;

import java.util.List;

public interface ICostService extends IService<Cost,Long>{
    List<Cost> getall();
}
