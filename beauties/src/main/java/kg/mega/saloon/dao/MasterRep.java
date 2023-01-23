package kg.mega.saloon.dao;

import kg.mega.saloon.models.entities.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterRep extends JpaRepository<Master, Long> {
    @Query("select s from Schedule s inner join Master m on s.id=:id")
    List<Master> findScheduleByMasterId(Long id);

    @Query("select m from Master m inner join Saloon s on m.saloon.id=:salonId")
    List<Master> findMasterBySalonId(Long salonId);

}
