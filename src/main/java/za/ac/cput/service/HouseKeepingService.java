package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Housekeeping;
import za.ac.cput.repository.HouseKeepingRepository;

import java.util.List;

@Service
public class HouseKeepingService implements IHouseKeepingService{

    private final HouseKeepingRepository houseKeepingRepositoryObj;
    @Autowired
    protected HouseKeepingService(HouseKeepingRepository houseKeepingRepositoryObj){
        this.houseKeepingRepositoryObj=houseKeepingRepositoryObj;
    }

    @Override
    public List<Housekeeping> getall() {
        return houseKeepingRepositoryObj.findAll();
    }

    @Override
    public Housekeeping create(Housekeeping housekeeping) {
        return houseKeepingRepositoryObj.save(housekeeping);
    }

    @Override
    public Housekeeping update(Housekeeping housekeeping) {
        return houseKeepingRepositoryObj.save(housekeeping);
    }

    @Override
    public Housekeeping read(Long id) {
        return houseKeepingRepositoryObj.findById(id).orElse(null);
    }
}
