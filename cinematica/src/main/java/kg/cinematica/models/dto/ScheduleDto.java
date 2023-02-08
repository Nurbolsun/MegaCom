package kg.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleDto {
    Long id;
    LocalDate startDate;
    LocalTime startTime;

    Date updateDate;
    boolean active;

    public ScheduleDto(LocalDate startDate, LocalTime startTime) {
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public ScheduleDto() {

    }
}
