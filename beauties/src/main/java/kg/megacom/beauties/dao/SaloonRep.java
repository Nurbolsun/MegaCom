package kg.megacom.beauties.dao;

import kg.megacom.beauties.models.entities.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaloonRep extends JpaRepository<Salon, Long> {
}
