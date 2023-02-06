package kg.cinematica.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
        Long id;
        int price;
        LocalTime startTime;
        Date addDate;
        Date updateDate;
        boolean active;
}
