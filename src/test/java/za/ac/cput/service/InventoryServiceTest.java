package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.factory.InventoryFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;
    private static Inventory inventory;
    private List<ItemType> itemTypes;


    @Test
    @Order(1)
    void a_setup() {
        itemTypes = new ArrayList<>();
        ItemType itemType1 = new ItemType.Builder()
                .setItemTypeId(1)
                .setItemName("Laptop")
                .setCategory("Electronics")
                .setCost(1000)
                .setSupplierName("Supplier A")
                .build();

        ItemType itemType2 = new ItemType.Builder()
                .setItemTypeId(2)
                .setItemName("Phone")
                .setCategory("Electronics")
                .setCost(500)
                .setSupplierName("Supplier B")
                .build();

        itemTypes.add(itemType1);
        itemTypes.add(itemType2);

        inventory = InventoryFactory.buildInventory(111235987L, 10, itemTypes);

        assertNotNull(inventory);
        System.out.println(inventory.toString());


    }
    @Test
    @Order(5)
    void getall() {
        System.out.println(inventoryService.getall());

    }

    @Test
    @Order(2)
    void create() {
        Inventory created1=inventoryService.create(inventory);
        assertNotNull(created1);
        System.out.println(created1.toString());

    }

    @Test
    @Order(3)
    void update() {
        Inventory newInvnt = new Inventory.Builder().copy(inventory).setQuantity(11).build();
        Inventory updated= inventoryService.update(newInvnt);
        assertNotNull(updated);
        System.out.println(updated.toString());

    }

    @Test
    @Order(4)
    void read() {
        Inventory read=inventoryService.read(inventory.getInventoryId());
        assertNotNull(read);
        System.out.println(read);

    }
}