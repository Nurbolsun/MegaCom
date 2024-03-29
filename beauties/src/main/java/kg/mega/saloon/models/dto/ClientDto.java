package kg.mega.saloon.models.dto;

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
    String phoneNumber;
    String email;
    boolean active;
}
