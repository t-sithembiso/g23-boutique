package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.InventoryRepository;

import java.util.List;
@Service
public class InventoryService implements IInventoryService{

    private InventoryRepository inventoryRepository;
    @Autowired
    protected InventoryService(InventoryRepository inventoryRepository){

        this.inventoryRepository=inventoryRepository;
    }
    @Override
    public List<Inventory> getall() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory read(Long aLong) {
        return inventoryRepository.findById(aLong).orElse(null);
    }
}
