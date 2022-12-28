package kg.megacom.beauties.models.dtos;

import kg.megacom.beauties.models.MasterSchedule;
import kg.megacom.beauties.models.Salon;
import kg.megacom.beauties.models.enums.WorkTypeEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MasterDto {
    Long id;
    String name;
    String surname;
    SalonDto salon;
    MasterScheduleDto schedule;
    WorkTypeEnum workType;
}
