

 package za.ac.cput.factory;

 import za.ac.cput.domain.ItemType;
 import za.ac.cput.domain.Supplier;
 import za.ac.cput.util.Helper;

 import java.util.Set;

 public class ItemTypeFactory {
     public static ItemType buildItemType(long itemTypeId, String itemName, String category, int cost, Set<Supplier> supplierName) {
         if (Helper.isNullorEmpty(String.valueOf(itemTypeId)) || Helper.isNullorEmpty(itemName) ||
                 Helper.isNullorEmpty(category) || Helper.isNullorEmpty(String.valueOf(cost)) ||
                supplierName == null)
             return null;

         return new ItemType.Builder()
                 .setItemTypeId(itemTypeId)
                 .setItemName(itemName)
                 .setCategory(category)
                 .setCost(cost)
                 .setSuppliers(supplierName)
                 .build();
     }
 }


