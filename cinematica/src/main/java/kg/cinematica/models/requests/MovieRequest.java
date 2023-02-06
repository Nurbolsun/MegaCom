package kg.cinematica.models.requests;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieRequest {
    String def;
    String name;
    String image;
    Double rating;
    String pg;
}
