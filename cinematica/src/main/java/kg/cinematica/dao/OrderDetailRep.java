package kg.cinematica.dao;

import kg.cinematica.models.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRep extends JpaRepository<OrderDetail, Long> {
}
