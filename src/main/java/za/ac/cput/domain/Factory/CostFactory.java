package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Cost;
import za.ac.cput.util.Helper;
import java.util.Date;
public class CostFactory {

    public static Cost buildCost(String costId, String inventoryId, String costDescription, Double amount, Date dateIncurred){
        if (Helper.isNullorEmpty(costId) ||
            Helper.isNullorEmpty(inventoryId) ||
                Helper.isNullorEmpty(costDescription) ||
                amount < 0 ||
                dateIncurred == null) {
            return null;
        }

        // Create and return a new Cost object
        return new Cost.Builder().setCostId(costId)
                .setCostDescription(costDescription)
                .setAmount(amount)
                .setDateIncurred(dateIncurred)
                .setInventoryId(inventoryId)
                .build();
    }



}
