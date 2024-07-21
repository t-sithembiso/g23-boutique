package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.ItemType;
import za.ac.cput.util.Helper;

import java.util.List;
<<<<<<< HEAD
import java.util.Set;

public class InventoryFactory {

    public static Inventory buildInventory(long inventoryId, int quantity, ItemType itemTypes) {
        if (inventoryId <=0 || quantity <= 0 ||
                itemTypes == null)
=======

public class InventoryFactory {

    public static Inventory buildInventory(Long inventoryId, int quantity, List<ItemType> itemTypes) {
        if (Helper.isNullorEmpty(String.valueOf(inventoryId)) || Helper.isNullorEmpty(String.valueOf(quantity)) ||
                itemTypes == null || itemTypes.isEmpty())
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
            return null;

        return new Inventory.Builder()
                .setInventoryId(inventoryId)
                .setQuantity(quantity)
                .setItemTypes(itemTypes)
                .build();
    }
}


 
