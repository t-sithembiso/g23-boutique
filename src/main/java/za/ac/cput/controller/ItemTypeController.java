package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ItemType;
import za.ac.cput.service.ItemTypeService;

import java.util.List;

@RestController
@RequestMapping("/itemtype")
public class ItemTypeController {
    @Autowired
    private ItemTypeService itemTypeService;
    @Transactional
    @PostMapping("/create")
    public ItemType create(@RequestBody ItemType itemType) {
        return itemTypeService.create(itemType);
    }

    @Transactional
    @PostMapping("/update")
    public ItemType update(@RequestBody ItemType itemType) {
        return itemTypeService.update(itemType);
    }

    @Transactional(readOnly = true)
    @GetMapping("/read/{bookingId}")
    public ItemType read(@PathVariable Long itemTypeId) {
        return itemTypeService.read(itemTypeId);
    }

    @Transactional(readOnly = true)
    @GetMapping("/getall")
    public List<ItemType> getall() {
        return itemTypeService.getall();
    }

}
