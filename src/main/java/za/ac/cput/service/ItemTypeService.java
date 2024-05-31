package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.ItemType;
import za.ac.cput.repository.ItemTypeRepository;

import java.util.List;
@Service
public class ItemTypeService implements IItemTypeService{
    private final ItemTypeRepository itemTypeRepository;

    protected ItemTypeService(ItemTypeRepository itemType){
        this.itemTypeRepository = itemType;
    }

    @Override
    public List<ItemType> getall() {
        return itemTypeRepository.findAll();
    }

    @Override
    public  ItemType create(ItemType itemType) {
        return itemTypeRepository.save(itemType);
    }

    @Override
    public ItemType update(ItemType itemType) {
        return itemTypeRepository.save(itemType);
    }

    @Override
    public ItemType read(Long aLong) {
        return itemTypeRepository.findById(aLong).orElse(null);
    }
}
