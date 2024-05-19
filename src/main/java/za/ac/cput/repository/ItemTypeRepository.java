package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ItemType;
@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    ItemType findEmployeeBaseByEmployeeId(Long employeeId);
}
