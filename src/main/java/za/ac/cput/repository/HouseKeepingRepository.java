package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Housekeeping;
@Repository
public interface HouseKeepingRepository extends JpaRepository<Housekeeping, Long> {
}
