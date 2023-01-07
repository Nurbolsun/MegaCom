package kg.mega.saloon.models.entities;
import kg.mega.saloon.enums.WorkDayEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_master_schedule")
public class MasterSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //ключ будет генерироваться
    Long id;
    @Temporal(value = TemporalType.TIME)
    Date startTime;
    @Temporal(value = TemporalType.TIME)
    Date endTime;
    @Enumerated(EnumType.STRING)
    WorkDayEnum workDay;







}
