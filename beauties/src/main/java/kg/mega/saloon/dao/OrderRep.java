package kg.mega.saloon.dao;

import kg.mega.saloon.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRep extends JpaRepository<Order, Long> {
    List<Order> findOrderByMaster_Id(Long masterId);
    @Query("select o from Order as o where o.confirmCode=:confirmCode")
    Order findOrderByCode(int confirmCode);
}
