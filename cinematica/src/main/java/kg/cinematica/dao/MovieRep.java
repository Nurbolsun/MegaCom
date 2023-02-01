package kg.cinematica.dao;

import kg.cinematica.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRep extends JpaRepository<Movie, Long> {

}
