package kg.megacom.authorizationservice.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Date;

public interface AccountNameAndDateResponse {
    String getLogin();
    Date getAddDate();
}
