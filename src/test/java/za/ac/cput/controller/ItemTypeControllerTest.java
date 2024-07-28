package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        Supplier supplier = new Supplier.Builder()
                .setSupplierId(111235987L)
                .setContactNumber("0123456789")
                .setAddress("123 Sirlowry Woodstock east")
                .setContactPerson("Jerry")
                .setName("Jeff")
                .setEmail("jerry@gmail.com")
                .build();
        suppliers.add(supplier);
        itemType = ItemTypeFactory.buildItemType(23L, "Soap", "bathroom", 25, suppliers);
    }

    @Test
    void a_create() {
        String url = Base_Url + "create";
        ResponseEntity<ItemType> postResponse = restTemplate.postForEntity(url, itemType, ItemType.class);
        assertNotNull(postResponse);
        ItemType saveItemType = postResponse.getBody();
        assertNotNull(saveItemType);
//        assertEquals(itemType.getItemTypeId(), saveItemType.getItemTypeId());
        System.out.println("Created ItemType: " + saveItemType);
    }

    @Test
    void b_update() {
        String url = Base_Url + "update";
        ItemType updatedItemType = new ItemType.Builder()
                .copy(itemType)
                .setCost(30)
                .build();
        HttpEntity<ItemType> request = new HttpEntity<>(updatedItemType);
        ResponseEntity<ItemType> response = restTemplate.exchange(url, HttpMethod.PUT, request, ItemType.class);
        assertNotNull(response.getBody());
        assertEquals(30, response.getBody().getCost());
        System.out.println("Updated ItemType: " + response.getBody());
    }

    @Test
    void c_read() {
        String url = Base_Url + "read/" + itemType.getItemTypeId();
        ResponseEntity<ItemType> response = restTemplate.getForEntity(url, ItemType.class);
        assertNotNull(response.getBody());
        assertEquals(itemType.getItemTypeId(), response.getBody().getItemTypeId());
        System.out.println("Read ItemType: " + response.getBody());
    }

    @Test
    void d_getAll() {
        String url = Base_Url + "all";
        ResponseEntity<ItemType[]> response = restTemplate.getForEntity(url, ItemType[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("All ItemTypes: ");
        for (ItemType it : response.getBody()) {
            System.out.println(it);
        }
    }
}
