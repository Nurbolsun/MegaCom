package kg.cinematica.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomDto {
    Long id;
    CinemaDto cinema;
    String name;
    Date addDate;
    Date updateDate;
    boolean active;

}
