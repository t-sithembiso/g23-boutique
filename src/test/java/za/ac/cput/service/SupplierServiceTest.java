package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    private static Supplier supplier1;

@BeforeAll
    static  void setup() {
        supplier1 = SupplierFactory.buildSupplier(111235987L, "Tesco", "Marvin Gerad", "0810000106", "tesco@reply.com", "108 Welwin garden city");
        assertNotNull(supplier1);
        System.out.println(supplier1);
    }

    @Test
    void a_create() {
        Supplier created1 = supplierService.create(supplier1);
        assertNotNull(created1);

        System.out.println(created1);
    }

    @Test
    void b_read() {
        Long read = supplierService.read(supplier1.getSupplierId());
        assertNotNull(read);  System.out.println(read);
    }

    @Test
    void c_update(){
        Supplier newSupplier = new Supplier.Builder().copy(supplier1).setName("Marcels Sheets").build();
        Supplier updated = supplierService.update(newSupplier);
        assertNotNull(updated);
        assertEquals("Marcels Sheets", updated.getName());
        System.out.println(updated);
    }

    @Test
    void d_getAll()  {
        System.out.println(supplierService.getAll());
    }
}

