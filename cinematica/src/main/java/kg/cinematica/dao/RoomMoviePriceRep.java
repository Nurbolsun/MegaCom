package kg.cinematica.dao;

import kg.cinematica.models.entities.RoomMoviePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RoomMoviePriceRep extends JpaRepository<RoomMoviePrice, Long> {
    @Query(value = "select * from tb_room_movie_price as rmp\n" +
            "inner join tb_room_movie as rm on rmp.room_movie_id=rm.id\n" +
            "\n" +
            "inner join tb_schedule as s on rm.schedule_id=s.id\n" +
            "where rm.movie_id=:movieId and  s.start_day=:startDate",nativeQuery = true)
    List<RoomMoviePrice> findPriceByMovieId(Long movieId, LocalDate startDate);
}
