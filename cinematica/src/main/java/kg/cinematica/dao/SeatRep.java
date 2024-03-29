package kg.cinematica.dao;

import kg.cinematica.models.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRep extends JpaRepository<Seat, Long> {
    @Query(value = "select * from tb_seat as s \n" +
            "WHERE s.room_id=:roomId",nativeQuery = true)
    List<Seat> findSeatsByRoomId(Long roomId);
}
