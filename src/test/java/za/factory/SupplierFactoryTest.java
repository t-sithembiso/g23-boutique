package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {


    @Test
    void buildSupplier() {
        Supplier supplierCreated= SupplierFactory.buildSupplier(111235987L,"Tesco","Marvin Gerad","0810000106","tesco@reply.com","108 Welwin garden city") ;

        assertNotNull(supplierCreated);
        System.out.println(supplierCreated.toString());
    }
}