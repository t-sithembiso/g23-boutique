
 package za.ac.cput.factory;

 import za.ac.cput.domain.ItemType;
 import za.ac.cput.util.Helper;

 public class ItemTypeFactory {
     public static ItemType buildItemType(long itemTypeId, String itemName, String category, int cost, String supplierName) {
         if (Helper.isNullorEmpty(String.valueOf(itemTypeId)) || Helper.isNullorEmpty(itemName) ||
                 Helper.isNullorEmpty(category) || Helper.isNullorEmpty(String.valueOf(cost)) ||
                 Helper.isNullorEmpty(supplierName))
             return null;

         return new ItemType.Builder()
                 .setItemTypeId(itemTypeId)
                 .setItemName(itemName)
                 .setCategory(category)
                 .setCost(cost)
                 .setSupplierName(supplierName)
                 .build();
     }
 }
