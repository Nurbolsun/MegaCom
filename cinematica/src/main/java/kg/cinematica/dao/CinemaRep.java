package kg.cinematica.dao;

import kg.cinematica.models.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRep extends JpaRepository<Cinema, Long> {
}
