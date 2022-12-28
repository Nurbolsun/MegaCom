package kg.megacom.beauties.dao;

import kg.megacom.beauties.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRep extends JpaRepository<Order, Long> {
}
