package kg.megacom.cinematica.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CinemaDto {
    Long id;
    String name;
    String address;
    String logo;
    boolean isActive;
    Date addDate;
    Date updateDate;
}
