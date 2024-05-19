package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Guest;
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

}
