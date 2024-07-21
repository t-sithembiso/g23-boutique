package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    /*@Transactional
    @PostMapping("/create")
    public Inventory create(@RequestBody Inventory inventory) {
        return InventoryService.create(inventory);
    }
*/
    @Transactional
    @PostMapping("/update")
    public Inventory update(@RequestBody Inventory inventory) {
        return inventoryService.update(inventory);
    }

    @Transactional(readOnly = true)
    @GetMapping("/read/{inventoryId}")
    public Inventory read(@PathVariable Long inventoryId) {
        return inventoryService.read(inventoryId);
    }

    @Transactional(readOnly = true)
    @GetMapping("/getall")
    public List<Inventory> getall() {
        return inventoryService.getall();
    }
}
