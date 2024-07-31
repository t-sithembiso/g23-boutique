package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<Inventory> create(@RequestBody Inventory inventory) {
        Inventory createdInventory = inventoryService.create(inventory);
        return ResponseEntity.ok(createdInventory);
    }

    @Transactional
    @PostMapping("/update")
    public ResponseEntity<Inventory> update(@RequestBody Inventory inventory) {
        Inventory updatedInventory = inventoryService.update(inventory);
        return ResponseEntity.ok(updatedInventory);
    }

    @Transactional(readOnly = true)
    @GetMapping("/read/{inventoryId}")
    public ResponseEntity<Inventory> read(@PathVariable Long inventoryId) {
        Inventory inventory = inventoryService.read(inventoryId);
        return ResponseEntity.ok(inventory);
    }


    @Transactional(readOnly = true)
    @GetMapping("/getall")
    public List<Inventory> getall() {
        return inventoryService.getall();
    }
}
