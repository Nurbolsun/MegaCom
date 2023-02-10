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
    int childPrice;
    int studentPrice;
    int adultPrice;
    LocalTime startTime;

}
