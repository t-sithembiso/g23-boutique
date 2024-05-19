package za.ac.cput.service;

import za.ac.cput.domain.ItemType;
import za.ac.cput.repository.ItemTypeRepository;

import java.util.List;

public class ItemTypeService implements IItemTypeService{
    private ItemTypeRepository itemTypeRepository;

    protected ItemTypeService(ItemTypeRepository itemTypeRepository){
        this.itemTypeRepository = itemTypeRepository;
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
