package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Cost;

public interface CostRepository extends JpaRepository<Cost, Long> {
}
