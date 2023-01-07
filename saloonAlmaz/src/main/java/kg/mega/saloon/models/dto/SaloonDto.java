package kg.mega.saloon.models.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.mega.saloon.models.entities.Master;
import kg.mega.saloon.models.entities.MasterSchedule;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaloonDto {
    Long id;
    String name;
    String address;
    String phoneNumber;
    @JsonIgnore
    boolean active;
}
