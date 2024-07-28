package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Supplier;
import za.ac.cput.service.SupplierService;

import java.util.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

   @Autowired
   private SupplierService supplierService;

   @PostMapping("/create")
   public Supplier create(@RequestBody Supplier supplier){

        return supplierService.create(supplier);
    }

    @PostMapping("/update")
    public Supplier update (@RequestBody Supplier supplier) {
       return supplierService.update(supplier);
    }

    @GetMapping("/read/supplierId")
    public Supplier read(@PathVariable Long supplierId){
       return supplierService.read(supplierId);
    }

    public List<Supplier> getall()  {

       return supplierService.getall();
    }







}
