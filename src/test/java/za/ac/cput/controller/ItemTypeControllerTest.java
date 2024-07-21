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
import za.ac.cput.factory.ItemTypeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ItemTypeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_Url = "http://localhost:8080/boutique/itemtype/";
    private static ItemType itemType;
    public static void setup() {
        itemType = ItemTypeFactory.buildItemType(23L,"Soap","bathroom",25,"Unliver");
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