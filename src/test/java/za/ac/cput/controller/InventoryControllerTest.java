package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.InventoryFactory;
import za.ac.cput.factory.ItemTypeFactory;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class InventoryControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_Url = "http://localhost:8080/boutique/inventory/";

    private static Inventory inventory;

    @BeforeEach
    void setUp() {
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
        ItemType itemType = ItemTypeFactory.buildItemType(23L, "Soap", "bathroom", 25, suppliers);
        inventory = InventoryFactory.buildInventory(111289L,13,itemType);
    }

    @Test
    void a_create() {
        String url = Base_Url + "create";
        ResponseEntity<Inventory> postResponse = restTemplate.postForEntity(url, inventory, Inventory.class);
        assertNotNull(postResponse);
        Inventory saveInventory = postResponse.getBody();
        assertNotNull(saveInventory);
    }

    @Test
    void b_update() {
        String url = Base_Url + "update";
        Inventory updatedInventory = new Inventory.Builder()
                .copy(inventory)
                .setQuantity(10)
                .build();
        HttpEntity<Inventory> request = new HttpEntity<>(updatedInventory);
        ResponseEntity<Inventory> response = restTemplate.exchange(url, HttpMethod.PUT, request, Inventory.class);
        assertNotNull(response.getBody());

        System.out.println("Updated Inventory: " + response.getBody());
    }

    @Test
    void c_read() {
        String url = Base_Url + "read/" + inventory.getInventoryId();
        ResponseEntity<Inventory> response = restTemplate.getForEntity(url, Inventory.class);
        assertNotNull(response.getBody());
        assertEquals(inventory.getInventoryId(), response.getBody().getInventoryId());
        System.out.println("Read Inventory: " + response.getBody());
    }

    @Test
    void d_getAll() throws Exception {
        String url = Base_Url + "all";
        ResponseEntity<Inventory[]> response = restTemplate.getForEntity(url, Inventory[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("All Inventory Items: ");
        for (Inventory it : response.getBody()) {
            System.out.println(it);
        }
    }
}
