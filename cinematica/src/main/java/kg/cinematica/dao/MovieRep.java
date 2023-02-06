package kg.cinematica.dao;

import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.entities.Movie;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface MovieRep extends JpaRepository<Movie, Long> {
   // @Query("SELECT id, image, pg, name from Movie")
    List<Movie> findAllByActiveIsTrue(PageRequest pageable);


}
