package kg.cinematica.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.net.URL;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieDto {
    Long id;
    String def;
    String name;
    String image;
    Double rating;
    String pg;
    Date addDate;
    Date updateDate;
    boolean active;
}
