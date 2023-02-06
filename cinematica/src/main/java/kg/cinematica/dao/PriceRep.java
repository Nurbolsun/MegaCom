package kg.cinematica.dao;

import kg.cinematica.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRep extends JpaRepository<Price, Long> {
}
