package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Guest;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
