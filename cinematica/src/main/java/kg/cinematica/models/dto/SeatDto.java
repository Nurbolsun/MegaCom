package kg.cinematica.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatDto {
    Long id;
    int num;
    int row;
    Date addDate;
    Date updateDate;
    boolean active;
    RoomDto room;
}
