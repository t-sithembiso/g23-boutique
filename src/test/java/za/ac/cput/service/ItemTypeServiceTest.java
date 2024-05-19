package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ItemType;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ItemTypeServiceTest {
private ItemTypeService itemTypeService;
private static ItemType itemTypeObj;
    @Test
    void getall() {
        System.out.println(itemTypeService.getall());
    }
    void a_create() {
        ItemType created1=itemTypeService.create(itemTypeObj);
        assertNotNull(created1);
        System.out.println(created1.toString());

    }

    @Test
    void update() {
        ItemType newItem = new ItemType.Builder().copy(itemTypeObj).setCost(31).build();
        ItemType updated= itemTypeService.update(newItem);
        assertNotNull(updated);
        System.out.println(updated.toString());

    }

    @Test
    void read() {
        ItemType read=itemTypeService.read(itemTypeObj.getItemTypeId());
        assertNotNull(read);
        System.out.println(read);

    }}