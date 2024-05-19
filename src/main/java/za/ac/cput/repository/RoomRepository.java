package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Amenity> {

}
