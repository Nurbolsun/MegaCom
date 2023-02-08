package kg.cinematica.models.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomMovieResponse {
    Long id;
    Double childPrice;
    Double studentPrice;
    Double adultPrice;
    LocalTime startTime;

}
