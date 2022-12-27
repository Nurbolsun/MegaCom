package kg.megacom.authorizationservice.models.dtos;

import kg.megacom.authorizationservice.models.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class AccountDto {
    Long id;
    String login;
    String password;
    int count;
    AccountStatus status;
    Date addDate;
    Date updateDate;
    boolean active;
}
