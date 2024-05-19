package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.domain.Staff;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    private List<ItemType> itemTypes;

    @BeforeEach
    void setUp() {
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
    }

    @Test
    void testBuildInventorySuccess() {
        Inventory inventory = InventoryFactory.buildInventory(1L, 10, itemTypes);
        assertNotNull(inventory);
        assertEquals(1L, inventory.getInventoryId());
        assertEquals(10, inventory.getQuantity());
        assertEquals(itemTypes, inventory.getItemTypes());
        System.out.println(inventory);
    }

    @Test
    void testBuildInventoryWithNullItemTypes() {
        Inventory inventory = InventoryFactory.buildInventory(1L, 10, null);
        assertNull(inventory);
    }

    @Test
    void testBuildInventoryWithEmptyItemTypes() {
        Inventory inventory = InventoryFactory.buildInventory(1L, 10, new ArrayList<>());
        assertNull(inventory);
    }

    @Test
    void testBuildInventoryWithNullId() {
        Inventory inventory = InventoryFactory.buildInventory(null, 10, itemTypes);
        assertNull(inventory);
    }

    @Test
    void testBuildInventoryWithInvalidQuantity() {
        Inventory inventory = InventoryFactory.buildInventory(1L, -1, itemTypes);
        assertNull(inventory);
    }

    @Test
    void testBuildInventoryWithHelper() {
        // Assume Helper.isNullorEmpty(String) is implemented correctly
        assertFalse(Helper.isNullorEmpty("test"));
        assertTrue(Helper.isNullorEmpty(""));
    }
}
