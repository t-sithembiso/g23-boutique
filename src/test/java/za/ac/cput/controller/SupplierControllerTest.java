package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)

class SupplierControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_Url = "http://localhost:8080/boutique/supplier/";
    private static Supplier supplier1;
    private static Supplier supplier2 ;

    @BeforeEach
    void setUp() {

        supplier1= SupplierFactory.buildSupplier(111235987L,"Tesco","Marvin Gerad","0810000106","tesco@reply.com","108 Welwin garden city") ;
        supplier2= SupplierFactory.buildSupplier(80001L,"Johnsons","Ezra Kani","02100900106","johnsons@reply.com","207 Welwin garden city") ;

    }

    @Test
    void a_create() {

        String url = Base_Url+"create";

        ResponseEntity<Supplier> postResponse = restTemplate.postForEntity(url, supplier1, Supplier.class);
        assertNotNull(postResponse);
        Supplier savedSupplier = postResponse.getBody();
        assertEquals(supplier1.getSupplierId(),savedSupplier.getSupplierId());
        assertNotNull(savedSupplier);
        System.out.println(savedSupplier);

        ResponseEntity<Supplier> supplierResponse = restTemplate.postForEntity(url, supplier2, Supplier.class);
        assertNotNull(supplierResponse);
        assertNotNull(supplierResponse.getBody());
        System.out.println(supplierResponse.getBody());
    }

    @Test
    void b_update() {

        String url = Base_Url+"update";
        Supplier supplier = new Supplier.Builder().copy(supplier2).setEmail("johnsons@orders.com").build();
        ResponseEntity<Supplier> updateResponse = restTemplate.postForEntity(url,supplier,Supplier.class);
        assertNotNull(updateResponse);
        assertNotNull(updateResponse.getBody());
        System.out.println(updateResponse.getBody());
    }

    @Test
    void c_read() {
        String url = Base_Url+"read/"+supplier1.getSupplierId() ;
        ResponseEntity<Supplier> read = restTemplate.getForEntity(url, Supplier.class);
        assertNotNull(read);
        assertNotNull(read.getBody());
        System.out.println(read.getBody());
    }

    @Test
    void d_getall() {
        String url = Base_Url+"getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseAll = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(responseAll.getBody());
    }
    }
