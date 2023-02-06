package kg.cinematica.models.requests;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.Date;
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleRequest {
    Date addDate;
    LocalTime startTime;

}
