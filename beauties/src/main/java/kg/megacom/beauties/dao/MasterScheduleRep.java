package kg.megacom.beauties.dao;

import kg.megacom.beauties.models.entities.MasterSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterScheduleRep extends JpaRepository<MasterSchedule, Long> {
}
