package kg.megacom.beauties.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalonDto {
    Long id;
    String name;
    String address;
    String cellPhoneNum;
}
