package za.ac.cput.domain.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cost;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertNull;

class CostFactoryTest {

    @Test
    void buildCost() {

        Cost cost = CostFactory.buildCost("C001", "INV001", "", 100.0, new Date());
        assertNull(cost);
    }
}