package kg.cinematica.dao;

import kg.cinematica.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
}
