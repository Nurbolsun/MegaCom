package kg.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        @JsonIgnore
        Date addDate;
        @JsonIgnore
        Date updateDate;
        @JsonIgnore
        boolean active;
}
