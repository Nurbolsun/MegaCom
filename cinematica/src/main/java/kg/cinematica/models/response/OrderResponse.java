package kg.cinematica.models.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    long orderId;
    String movieName;
    String cinemaName;
    String room;
    List<SeatResponse> seatResponses;
    LocalDate startDate;
    LocalTime startTime;
    int totalPrice;
}
