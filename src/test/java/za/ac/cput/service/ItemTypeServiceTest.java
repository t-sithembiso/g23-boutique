package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ItemType;
import za.ac.cput.factory.ItemTypeFactory;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ItemTypeServiceTest {
    @Autowired
private ItemTypeService itemTypeService;
private static ItemType itemTypeObj;
    @Test
    @Order(1)
    void setup(){
        itemTypeObj= ItemTypeFactory.buildItemType(1,"Pencil","Stationary",12,"Unilever") ;
        assertNotNull(itemTypeObj);
        System.out.println(itemTypeObj.toString());

    }
    @Test
    @Order(5)
    void getall() {
        System.out.println(itemTypeService.getall());
    }
    @Test
    @Order(2)
    void create() {
        ItemType created1=itemTypeService.create(itemTypeObj);
        assertNotNull(created1);
        System.out.println(created1.toString());

    }

    @Test
    @Order(3)
    void update() {
        ItemType newItem = new ItemType.Builder().copy(itemTypeObj).setCost(31).build();
        ItemType updated= itemTypeService.update(newItem);
        assertNotNull(updated);
        System.out.println(updated.toString());

    }

    @Test
    @Order(4)
    void read() {
        ItemType read=itemTypeService.read(itemTypeObj.getItemTypeId());
        assertNotNull(read);
        System.out.println(read);

    }}