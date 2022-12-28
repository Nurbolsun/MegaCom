package kg.megacom.beauties.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_salon")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;
    String cellPhoneNum;

}
