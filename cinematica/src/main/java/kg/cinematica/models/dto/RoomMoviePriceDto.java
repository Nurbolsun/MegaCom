package kg.cinematica.models.dto;

import kg.cinematica.models.entities.Price;
import kg.cinematica.models.entities.RoomMovie;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomMoviePriceDto {

    Long id;
    PriceDto price;
    RoomMovieDto roomMovie;
    Date addDate;
    Date updateDate;
    boolean active;
}
