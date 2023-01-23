package kg.mega.saloon.models.requests;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientRequest {
    String name;
    String surname;
    String email;
    String number;
}
