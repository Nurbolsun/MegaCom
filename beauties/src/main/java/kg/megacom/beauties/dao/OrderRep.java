package kg.megacom.beauties.dao;

import kg.megacom.beauties.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRep extends JpaRepository<Order, Long> {
}
