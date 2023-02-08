package kg.cinematica.models.response;

import kg.cinematica.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatScheduleResponse {
    long seatScheduleId;
    Status status;
    int row;
    int num;

}
