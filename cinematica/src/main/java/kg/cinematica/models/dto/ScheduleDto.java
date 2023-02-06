package kg.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalTime;
import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleDto {
    Long id;
//    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
//    @Temporal(value = TemporalType.DATE)
    Date addDate;
//    @JsonFormat(pattern = "hh:mm", shape = JsonFormat.Shape.STRING)
//    @Temporal(value = TemporalType.TIME)
    LocalTime startTime;
    Date updateDate;
    boolean active;

    public ScheduleDto(Date addDate, LocalTime startTime) {
        this.addDate = addDate;
        this.startTime = startTime;
    }

    public ScheduleDto() {

    }
}
