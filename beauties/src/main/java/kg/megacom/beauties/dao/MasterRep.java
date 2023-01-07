package kg.megacom.beauties.dao;

import kg.megacom.beauties.models.entities.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRep extends JpaRepository<Master, Long> {
}
