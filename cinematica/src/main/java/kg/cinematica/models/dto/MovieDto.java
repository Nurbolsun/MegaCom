package kg.cinematica.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    Date addDate;
    @JsonIgnore
    Date updateDate;
    @JsonIgnore
    boolean active;
}
