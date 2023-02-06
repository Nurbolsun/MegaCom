package kg.cinematica.models.requests;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailRequest {
    Long seatScheduleId;
    Long oderId;
}
