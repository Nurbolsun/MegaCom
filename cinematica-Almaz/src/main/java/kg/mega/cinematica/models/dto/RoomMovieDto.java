package kg.mega.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.mega.cinematica.models.entities.WorkDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomMovieDto extends WorkDateDto {
    @JsonIgnore
    Long id;
    RoomDto room;
    MovieDto movie;
    ScheduleDto schedule;



}
