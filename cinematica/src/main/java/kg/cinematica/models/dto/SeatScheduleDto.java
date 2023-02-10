package kg.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    Date addDate;
    @JsonIgnore
    Date updateDate;
    @JsonIgnore
    boolean active;
}
