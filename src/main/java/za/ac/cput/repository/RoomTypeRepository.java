package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
