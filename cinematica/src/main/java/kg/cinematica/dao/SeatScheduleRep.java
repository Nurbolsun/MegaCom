package kg.cinematica.dao;

import kg.cinematica.models.entities.SeatSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatScheduleRep extends JpaRepository<SeatSchedule, Long> {
}
