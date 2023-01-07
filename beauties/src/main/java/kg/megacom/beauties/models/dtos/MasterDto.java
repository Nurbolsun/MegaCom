package kg.megacom.beauties.models.dtos;


import kg.megacom.beauties.enums.WorkTypeEnum;
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
    SaloonDto salon;
    MasterScheduleDto schedule;
    WorkTypeEnum workType;
    boolean active;
}
