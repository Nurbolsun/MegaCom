package kg.megacom.authorizationservice.models;

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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

    Date addDate;
    Date updateDate;
    boolean active;


    @PreUpdate
    protected void onUpdate(){
        updateDate=new Date();
    }



}
