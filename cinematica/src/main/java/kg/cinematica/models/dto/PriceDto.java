package kg.cinematica.models.dto;

import kg.cinematica.enums.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto {
    Long id;
    Double price;
    Type type;
    Date addDate;
    Date updateDate;
    boolean active;
}
