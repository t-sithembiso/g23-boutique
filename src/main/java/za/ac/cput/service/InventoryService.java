package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService implements IInventoryService{

    private final InventoryRepository inventoryRepository;
    @Autowired
    protected InventoryService(InventoryRepository invent){
        this.inventoryRepository=invent;
    }

    @Override
    @Transactional
    public Inventory create(Inventory inventory) {return inventoryRepository.save(inventory);}

    @Override
    @Transactional
    public Inventory update(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    @Transactional(readOnly = true)
    public Inventory read(Long aLong) {
        return inventoryRepository.findById(aLong).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inventory> getall() {
        return inventoryRepository.findAll();
    }
}

