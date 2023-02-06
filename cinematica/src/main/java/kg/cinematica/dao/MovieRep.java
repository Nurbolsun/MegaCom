package kg.cinematica.dao;

import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRep extends JpaRepository<Movie, Long> {
    @Query("SELECT m from Movie m where m.id = ?1")
    Movie findMovie(int id);


}
