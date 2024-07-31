package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.domain.Supplier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ItemTypeFactoryTest {

    @Test
    void buildItemTypeThatPass() {
        Set<Supplier> suppliers = new HashSet<>();
        Supplier supplier = new Supplier.Builder().setSupplierId(111235987L).setContactNumber("0123456789")
                .setAddress("123 Sirlowry Woodstock east")
                .setContactPerson("Jerry")
                .setName("Jeff")
                .setEmail("jerry@gmail.com").build();
        suppliers.add(supplier);
        ItemType itemType = ItemTypeFactory.buildItemType(123L, "Spoon","the",24,suppliers);
        assertNotNull(itemType);
        System.out.println(itemType.toString());
    }

}