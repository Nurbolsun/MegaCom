package kg.mega.saloon.dao;

import kg.mega.saloon.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRep extends JpaRepository<Schedule, Long> {

    @Query("select s from Schedule s inner join MasterSchedule m on s.id=m.schedule.id where m.master.id=:id")
    List<Schedule> findScheduleByMasterId(Long id);

}
