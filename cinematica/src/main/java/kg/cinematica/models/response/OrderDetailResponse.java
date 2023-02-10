package kg.cinematica.models.response;

import kg.cinematica.enums.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailResponse {
    Long orderId;
    String movie;
    String cinema;
    String room;
    int row;
    int num;
    Type priceType;
    LocalDate startDate;
    LocalTime startTime;
    int price;
}
