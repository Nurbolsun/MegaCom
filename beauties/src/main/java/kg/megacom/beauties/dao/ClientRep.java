package kg.megacom.beauties.dao;

import kg.megacom.beauties.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRep extends JpaRepository<Client, Long> {

}
