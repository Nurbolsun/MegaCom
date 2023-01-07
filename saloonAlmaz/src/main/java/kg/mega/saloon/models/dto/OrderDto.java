package kg.mega.saloon.models.dto;
import kg.mega.saloon.enums.OrderStatusEnum;
import kg.mega.saloon.models.entities.Client;
import kg.mega.saloon.models.entities.Master;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    Date addDate;
    Date updateDate;
    Date appointment_date;
    OrderStatusEnum status;
    Client client;
    Master master;
}
