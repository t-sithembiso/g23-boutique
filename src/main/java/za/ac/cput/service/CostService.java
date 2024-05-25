package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cost;
import za.ac.cput.repository.CostRepository;

import java.util.List;

@Service
public class CostService implements ICostService{
    private final CostRepository costRepository;
    @Autowired
    CostService(CostRepository costRepository){
        this.costRepository = costRepository;
    }
    @Override
    public Cost create(Cost cost) {
        return costRepository.save(cost);
    }

    @Override
    public Cost update(Cost cost) {
        return costRepository.save(cost);
    }

    @Override
    public Cost read(Long id) {
        return costRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cost> getall() {
        return costRepository.findAll();
    }
}
