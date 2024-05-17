package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
