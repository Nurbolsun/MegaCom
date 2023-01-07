package kg.megacom.beauties.models.dtos;

import kg.megacom.beauties.enums.OrderStatusEnum;
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
    Date appointmantDate;
    OrderStatusEnum status;
    ClientDto client;
    MasterDto master;
    boolean active;
}
