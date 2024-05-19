package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    private final SupplierRepository supplierRepositoryObj;
    @Autowired
    protected SupplierService(SupplierRepository supplierRepositoryObj){

        this.supplierRepositoryObj=supplierRepositoryObj;
    }


    @Override
    public Supplier create(Supplier supplier) {
        return supplierRepositoryObj.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return supplierRepositoryObj.save(supplier);
    }

    @Override
    public Supplier read(Long id) {
        return supplierRepositoryObj.findById(id).orElse(null);
    }

    @Override
    public List<Supplier> getall() {
        return  supplierRepositoryObj.findAll();
    }
}
