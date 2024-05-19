package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemTypeFactoryTest {

    @Test
    void buildItemTypeThatPass() {
        ItemType itemType = ItemTypeFactory.buildItemType(123, "Spoon","the",24,"jonhsons");
        assertNotNull(itemType);
        System.out.println(itemType.toString());
    }

}