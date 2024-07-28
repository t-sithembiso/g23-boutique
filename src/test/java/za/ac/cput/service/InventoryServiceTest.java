package za.ac.cput.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.InventoryFactory;
import za.ac.cput.factory.ItemTypeFactory;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class InventoryServiceTest {
    @Autowired
    private InventoryService inventoryService;
    private static Inventory inventory;

    InventoryServiceTest() {
    }

    @BeforeAll
    static void setup() {
        Set<Supplier> suppliers = new HashSet<>();
        Supplier supplier = new Supplier.Builder().setSupplierId(111235987L).setContactNumber("0123456789")
                .setAddress("123 Sirlowry Woodstock east")
                .setContactPerson("Jerry")
                .setName("Jeff")
                .setEmail("jerry@gmail.com").build();
        suppliers.add(supplier);
        ItemType itemType = ItemTypeFactory.buildItemType(6L, "Pen", "Stationary", 12, suppliers);

        inventory = InventoryFactory.buildInventory(111235987L, 10, itemType);
        Assertions.assertNotNull(inventory);
        System.out.println(inventory.toString());
    }

    @Test
    void a_create() {
        Inventory created1 = this.inventoryService.create(inventory);
        Assertions.assertNotNull(created1);
        System.out.println("Created an inventory values" + created1.toString());
    }

    @Test
    void b_update() {
        Inventory newInvnt = (new Inventory.Builder()).copy(inventory).setQuantity(11).build();
        Inventory updated = this.inventoryService.update(newInvnt);
        Assertions.assertNotNull(updated);
        System.out.println("Updated Inventory values" + updated.toString());
    }

    @Test
    void c_read() {
        Inventory InventoryRead = this.inventoryService.read(inventory.getInventoryId());
        System.out.println(InventoryRead.toString());
        Assertions.assertNotNull(InventoryRead);
        System.out.println(InventoryRead);
    }

    @Test
    void d_getall() {
        System.out.println("All that is in the Inventory table" + String.valueOf(this.inventoryService.getall()));
    }
}
