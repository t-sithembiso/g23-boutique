//https://github.com/sitgi/g23-boutique
package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Staff;


@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
