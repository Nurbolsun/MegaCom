package kg.megacom.beauties.models.dtos;

import kg.megacom.beauties.models.Client;
import kg.megacom.beauties.models.Master;
import kg.megacom.beauties.models.enums.OrderStatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
}
