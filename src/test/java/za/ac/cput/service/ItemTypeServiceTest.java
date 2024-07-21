package za.ac.cput.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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

    ItemTypeServiceTest() {
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
        itemTypeObj = ItemTypeFactory.buildItemType(1L, "Pencil", "Stationary", 12, suppliers);
        Assertions.assertNotNull(itemTypeObj);
        System.out.println(itemTypeObj);
    }

    @Test
    void a_create() {
        ItemType created1 = this.itemTypeService.create(itemTypeObj);
        Assertions.assertNotNull(created1);
        System.out.println(created1);
    }

    @Test
    void b_update() {
        ItemType newItem = (new ItemType.Builder()).copy(itemTypeObj).setCost(31).build();
        ItemType updated = this.itemTypeService.update(newItem);
        Assertions.assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void c_read() {
        ItemType read = this.itemTypeService.read(itemTypeObj.getItemTypeId());
        Assertions.assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_getall() {
        System.out.println(this.itemTypeService.getall());
    }
}
