package kg.cinematica.models.requests;

import kg.cinematica.enums.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceRequest {
    Double price;
    Type type;
}
