package kg.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    Date addDate;
    @JsonIgnore
    Date updateDate;
    @JsonIgnore
    boolean active;
    RoomDto room;
}
