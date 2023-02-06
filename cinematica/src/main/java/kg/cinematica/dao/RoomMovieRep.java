package kg.cinematica.dao;

import kg.cinematica.models.entities.RoomMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomMovieRep extends JpaRepository<RoomMovie, Long> {

}
