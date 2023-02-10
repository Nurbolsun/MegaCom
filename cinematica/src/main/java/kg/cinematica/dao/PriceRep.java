package kg.cinematica.dao;

import kg.cinematica.enums.Type;
import kg.cinematica.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRep extends JpaRepository<Price, Long> {
    @Query("Select p from Price as p\n" +
            "WHERE p.type= :priceType")
    List<Price> findPrice(Type priceType);
}
