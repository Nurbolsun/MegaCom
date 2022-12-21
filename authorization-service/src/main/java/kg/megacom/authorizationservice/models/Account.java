package kg.megacom.authorizationservice.models;

import kg.megacom.authorizationservice.models.enums.AccountStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String password;
    int count;
    AccountStatus status;
    Date addDate;
    Date updateDate;
    boolean active;


    @PreUpdate
    protected void onUpdate(){
        updateDate=new Date();
    }

    @PrePersist
    protected void onCreate(){
        status=AccountStatus.ACTIVE;
        addDate=new Date();
        updateDate=new Date();
        active=true;
        count=0;
    }

}
