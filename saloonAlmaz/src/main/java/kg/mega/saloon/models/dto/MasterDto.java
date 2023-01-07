package kg.mega.saloon.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.mega.saloon.enums.WorkTypeEnum;
import kg.mega.saloon.models.entities.MasterSchedule;
import kg.mega.saloon.models.entities.Saloon;
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
    Saloon saloon;
    MasterSchedule schedule;
    WorkTypeEnum workType;
    @JsonIgnore
    boolean active;


}
