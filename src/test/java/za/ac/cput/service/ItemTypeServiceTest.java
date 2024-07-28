package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ItemType;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.ItemTypeFactory;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ItemTypeServiceTest {

    @Autowired
    private ItemTypeService itemTypeService;
    private static ItemType itemTypeObj;

    @BeforeAll
    static void setup() {
        Set<Supplier> suppliers = new HashSet<>();
        Supplier supplier = new Supplier.Builder()
                .setSupplierId(111235987L)
                .setContactNumber("0123456789")
                .setAddress("123 Sirlowry Woodstock east")
                .setContactPerson("Jerry")
                .setName("Jeff")
                .setEmail("jerry@gmail.com")
                .build();
        suppliers.add(supplier);
        itemTypeObj = ItemTypeFactory.buildItemType(1L, "Pencil", "Stationary", 12, suppliers);
        Assertions.assertNotNull(itemTypeObj);
        System.out.println("Setup ItemType: " + itemTypeObj);
    }

    @Test
    void a_create() {
        ItemType createdItem = this.itemTypeService.create(itemTypeObj);
        Assertions.assertNotNull(createdItem);
        //Assertions.assertEquals(itemTypeObj.getItemTypeId(), createdItem.getItemTypeId());
        System.out.println("Created ItemType: " + createdItem);
    }

    @Test
    void b_update() {
        ItemType updatedItem = new ItemType.Builder()
                .copy(itemTypeObj)
                .setCost(31)
                .build();
        ItemType updated = this.itemTypeService.update(updatedItem);
        Assertions.assertNotNull(updated);
        Assertions.assertEquals(31, updated.getCost());
        System.out.println("Updated ItemType: " + updated);
    }

    @Test
    void c_read() {
        ItemType readItem = itemTypeService.read(itemTypeObj.getItemTypeId());
        System.out.println(itemTypeObj.getItemTypeId());
        System.out.println(itemTypeService.read(itemTypeObj.getItemTypeId()));
        Assertions.assertNotNull(readItem);
        Assertions.assertEquals(itemTypeObj.getItemTypeId(), readItem.getItemTypeId());
        System.out.println("Read ItemType: " + readItem);
    }

    @Test
    void d_getAll() {
        System.out.println(this.itemTypeService.getall());

    }
}
