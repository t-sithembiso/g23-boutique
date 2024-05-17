package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {
    private List<ItemType> cutlary;
    @Test
    void buildInventoryThatPass() {
        Inventory inventory = InventoryFactory.buildInventory(23, 34,cutlary);
        assertNotNull(inventory);
        System.out.println(inventory.toString());
    }

}