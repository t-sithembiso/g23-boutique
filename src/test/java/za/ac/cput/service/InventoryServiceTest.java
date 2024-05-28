package za.ac.cput.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
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
        ItemType itemType = ItemTypeFactory.buildItemType(1L, "Pencil", "Stationary", 12, "Unilever");
        List<ItemType> itemTypes = new ArrayList();
        itemTypes.add(itemType);
        inventory = InventoryFactory.buildInventory(111235987L, 10, itemTypes);
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
