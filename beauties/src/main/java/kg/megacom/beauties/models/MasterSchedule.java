package kg.megacom.beauties.models;

import kg.megacom.beauties.models.enums.WorkDayEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tb_master_schedule")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MasterSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(value = TemporalType.TIME)
    Date startTime;
    @Temporal(value = TemporalType.TIME)
    Date endTime;
    @Enumerated(EnumType.STRING)
    WorkDayEnum workDay;

}
