package kg.megacom.authorizationservice.models.dtos;

import kg.megacom.authorizationservice.models.entities.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class UsersDto {
    Long id;
    String name;
    Account account;
    Date addDate;
    Date updateDate;
    boolean active;
}
