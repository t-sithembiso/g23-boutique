package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.ItemType;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.ItemTypeFactory;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ItemTypeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_Url = "http://localhost:8080/boutique/itemtype/";
    private static ItemType itemType;
    public static void setup() {
        Set<Supplier> suppliers = new HashSet<>();
        Supplier supplier = new Supplier.Builder().setSupplierId(111235987L).setContactNumber("0123456789")
                .setAddress("123 Sirlowry Woodstock east")
                .setContactPerson("Jerry")
                .setName("Jeff")
                .setEmail("jerry@gmail.com").build();
        suppliers.add(supplier);
        itemType = ItemTypeFactory.buildItemType(23L,"Soap","bathroom",25,suppliers);
    }
    @Test
    void a_create() {
        String url = Base_Url+"create";
        ResponseEntity<ItemType> postResponse = restTemplate.postForEntity(url,itemType,ItemType.class);
        assertNotNull(postResponse);
        ItemType saveItemType = postResponse.getBody();
        assertNotNull(postResponse.getBody());
        assertEquals(itemType.getItemTypeId(),saveItemType.getItemTypeId());
        System.out.println("ItemType: " + saveItemType);
    }

    @Test
    void b_update() {
        String url = Base_Url+"update";
    }

    @Test
    void c_read() {
    }

    @Test
    void d_getall() {
    }
}