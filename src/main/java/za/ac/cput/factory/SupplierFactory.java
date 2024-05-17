package za.ac.cput.factory;

import za.ac.cput.domain.Supplier;
import za.ac.cput.util.Helper;

public class SupplierFactory {
    public static Supplier buildSupplier(Long supplierId,String name,String contactPerson,String contactNumber ,String email,String address){
        if(Helper.isNullorEmpty(String.valueOf(supplierId))|| Helper.isNullorEmpty(name)||
                Helper.isNullorEmpty(contactPerson)||Helper.isNullorEmpty(contactNumber)||
                Helper.isNullorEmpty( address)||   Helper.isNullorEmpty(email))
            return null;

        return new Supplier.Builder()
                .setSupplierId(supplierId)
                .setContactNumber(contactNumber)
                .setAddress(address)
                .setContactPerson(contactPerson)
                .setName(name)
                .setEmail(email)
                .build();
}
    }

