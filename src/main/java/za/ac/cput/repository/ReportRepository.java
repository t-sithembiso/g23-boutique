package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Report;
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
