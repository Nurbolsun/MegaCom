package kg.cinematica.dao;

import kg.cinematica.models.entities.RoomMoviePrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMoviePriceRep extends JpaRepository<RoomMoviePrice, Long> {
}
