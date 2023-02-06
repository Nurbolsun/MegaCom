package kg.cinematica.models.requests;

import kg.cinematica.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatScheduleRequest {
    Long seatId;
    Long roomMovieId;
    Status status;
}
