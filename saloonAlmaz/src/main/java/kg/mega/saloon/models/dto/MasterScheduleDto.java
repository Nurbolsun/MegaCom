package kg.mega.saloon.models.dto;
import kg.mega.saloon.enums.WorkDayEnum;
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
