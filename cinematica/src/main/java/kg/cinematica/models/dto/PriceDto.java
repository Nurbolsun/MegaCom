package kg.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    int price;
    Type type;
    @JsonIgnore
    Date addDate;
    @JsonIgnore
    Date updateDate;
    @JsonIgnore
    boolean active;
}
