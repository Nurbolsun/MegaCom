package kg.megacom.beauties.models.dtos;

import kg.megacom.beauties.models.enums.WorkDayEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MasterScheduleDto {
    Long id;
    Date startTime;
    Date endTime;
    WorkDayEnum workDay;
}
