package kg.cinematica.models.requests;

import kg.cinematica.models.dto.RoomDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatRequest {
    int num;
    int row;
    Long roomId;
}
