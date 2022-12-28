package kg.megacom.beauties.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {
    Long id;
    String name;
    String surname;
    String email;
    String cellPhoneNum;
}
