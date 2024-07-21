package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Set;

public class InventoryFactory {

    public static Inventory buildInventory(long inventoryId, int quantity, ItemType itemTypes) {
        if (inventoryId <=0 || quantity <= 0 ||
                itemTypes == null)
            return null;

        return new Inventory.Builder()
                .setInventoryId(inventoryId)
                .setQuantity(quantity)
                .setItemTypes(itemTypes)
                .build();
    }
}


 
