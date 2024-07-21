

 package za.ac.cput.factory;

 import za.ac.cput.domain.ItemType;
<<<<<<< HEAD
 import za.ac.cput.domain.Supplier;
 import za.ac.cput.util.Helper;

 import java.util.Set;

 public class ItemTypeFactory {
     public static ItemType buildItemType(long itemTypeId, String itemName, String category, int cost, Set<Supplier> supplierName) {
         if (Helper.isNullorEmpty(String.valueOf(itemTypeId)) || Helper.isNullorEmpty(itemName) ||
                 Helper.isNullorEmpty(category) || Helper.isNullorEmpty(String.valueOf(cost)) ||
                supplierName == null)
=======
 import za.ac.cput.util.Helper;

 public class ItemTypeFactory {
     public static ItemType buildItemType(long itemTypeId, String itemName, String category, int cost, String supplierName) {
         if (Helper.isNullorEmpty(String.valueOf(itemTypeId)) || Helper.isNullorEmpty(itemName) ||
                 Helper.isNullorEmpty(category) || Helper.isNullorEmpty(String.valueOf(cost)) ||
                 Helper.isNullorEmpty(supplierName))
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
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


