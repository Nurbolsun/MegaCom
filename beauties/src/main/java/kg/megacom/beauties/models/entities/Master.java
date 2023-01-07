package kg.megacom.beauties.models.entities;

import kg.megacom.beauties.enums.WorkTypeEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_master")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salon_id")
    Salon salon;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    MasterSchedule schedule;

    @Enumerated(EnumType.STRING)
    WorkTypeEnum workType;

}
