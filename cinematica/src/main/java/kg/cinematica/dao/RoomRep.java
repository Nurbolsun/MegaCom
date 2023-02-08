package kg.cinematica.dao;

import kg.cinematica.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRep extends JpaRepository<Room, Long> {
    @Query(value = "select * from tb_room as r \n" +
            "INNER JOIN tb_room_movie as rm\n" +
            "on r.id=rm.room_id\n" +
            "WHERE rm.\"id\"=:roomMovieId",nativeQuery = true)
    Room findRoomByRoomMovieId(Long roomMovieId);
}
