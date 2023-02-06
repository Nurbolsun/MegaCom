package kg.cinematica.dao;

import kg.cinematica.models.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatRep extends JpaRepository<Seat, Long> {
    @Query("select s from Seat s join fetch s.room where s.num=?1")
    Seat findRoom(String num);
}
