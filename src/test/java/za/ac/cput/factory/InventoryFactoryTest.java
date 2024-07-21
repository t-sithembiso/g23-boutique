package za.ac.cput.factory;

 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import za.ac.cput.domain.Inventory;
 import za.ac.cput.domain.ItemType;
 import za.ac.cput.domain.Supplier;
 import za.ac.cput.util.Helper;

 import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;

 import static org.junit.jupiter.api.Assertions.*;

 class InventoryFactoryTest {

     private ItemType itemType;

     @BeforeEach
     void setUp() {
         Set<Supplier> suppliers = new HashSet<>();
         Supplier supplier = new Supplier.Builder().setSupplierId(111235987L).setContactNumber("0123456789")
                 .setAddress("123 Sirlowry Woodstock east")
                 .setContactPerson("Jerry")
                 .setName("Jeff")
                 .setEmail("jerry@gmail.com").build();
         suppliers.add(supplier);

          itemType = new ItemType.Builder()
                 .setItemTypeId(1)
                 .setItemName("Laptop")
                 .setCategory("Electronics")
                 .setCost(1000)
                  .setSupplierName(suppliers)
                 .build();

     }

     @Test
     void testBuildInventorySuccess() {
         Inventory inventory = InventoryFactory.buildInventory(1L, 10, itemType);
         assertNotNull(inventory);
         assertEquals(1L, inventory.getInventoryId());
         assertEquals(10, inventory.getQuantity());
         assertEquals(itemType, inventory.getItemTypes());
         System.out.println(inventory);
     }

     @Test
     void testBuildInventoryWithNullItemTypes() {
         Inventory inventory = InventoryFactory.buildInventory(1L, 10, null);
         assertNull(inventory);
     }

//     @Test
//     void testBuildInventoryWithEmptyItemTypes() {
//         Inventory inventory = InventoryFactory.buildInventory(1L, 10,);
//         assertNull(inventory);
//     }
//
//     @Test
//     void testBuildInventoryWithNullId() {
//         Inventory inventory = InventoryFactory.buildInventory(null, 10, itemTypes);
//         assertNull(inventory);
//     }
//
//     @Test
//     void testBuildInventoryWithInvalidQuantity() {
//         Inventory inventory = InventoryFactory.buildInventory(1L, -1, itemTypes);
//         assertNull(inventory);
//     }

     @Test
     void testBuildInventoryWithHelper() {
         // Assume Helper.isNullorEmpty(String) is implemented correctly
         assertFalse(Helper.isNullorEmpty("test"));
         assertTrue(Helper.isNullorEmpty(""));
     }
 }
