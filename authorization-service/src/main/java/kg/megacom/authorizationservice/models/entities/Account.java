package kg.megacom.authorizationservice.models.entities;

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
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_account")
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String login;
    String password;
    @Column(name = "count_of_block")
    int count;
    AccountStatus status;

    @Temporal(TemporalType.TIME)
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
