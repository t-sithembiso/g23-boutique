package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
