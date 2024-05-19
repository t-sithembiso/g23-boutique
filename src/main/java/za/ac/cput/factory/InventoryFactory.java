package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.util.Helper;

import java.util.List;

public class InventoryFactory {

    public static Inventory buildInventory(Long inventoryId, int quantity, List<ItemType> itemTypes) {
        if (Helper.isNullorEmpty(String.valueOf(inventoryId)) || Helper.isNullorEmpty(String.valueOf(quantity)) ||
                itemTypes == null || itemTypes.isEmpty())
            return null;

        return new Inventory.Builder()
                .setInventoryId(inventoryId)
                .setQuantity(quantity)
                .setItemTypes(itemTypes)
                .build();
    }
}


 
