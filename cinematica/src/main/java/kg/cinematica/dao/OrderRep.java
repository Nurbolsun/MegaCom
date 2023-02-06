package kg.cinematica.dao;

import kg.cinematica.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRep extends JpaRepository<Order, Long> {
}
