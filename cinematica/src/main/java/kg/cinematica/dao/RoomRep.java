package kg.cinematica.dao;

import kg.cinematica.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRep extends JpaRepository<Room, Long> {
}
