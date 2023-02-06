package kg.cinematica.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailDto {
    Long id;
    SeatScheduleDto seatSchedule;
    OrderDto order;
    boolean active;
}
