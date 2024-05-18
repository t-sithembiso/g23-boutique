package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.util.Helper;

import java.util.List;

public class InventoryFactory {
    public static Inventory buildInventory(int inventoryId, int quantity, List<ItemType> itemType){
        if(Helper.isNullorEmpty(String.valueOf(inventoryId)) || Helper.isNullorEmpty(itemType.toString()) ||
                Helper.isNullorEmpty(String.valueOf(quantity)))
            return null;

        return new Inventory.Builder().setInventoryId(inventoryId).setQuantity(quantity).setItemType(itemType)
                .build();
    }
}
