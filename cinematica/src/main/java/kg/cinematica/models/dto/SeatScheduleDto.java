package kg.cinematica.models.dto;

import kg.cinematica.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatScheduleDto {
    Long id;
    SeatDto seat;
    RoomMovieDto roomMovie;
    Status status;
    Date addDate;
    Date updateDate;
    boolean active;
}
