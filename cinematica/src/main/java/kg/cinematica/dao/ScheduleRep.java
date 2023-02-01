package kg.cinematica.dao;

import kg.cinematica.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRep extends JpaRepository<Schedule, Long> {


}
