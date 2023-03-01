package kg.megacom.cinematica.models.dtos;

import kg.megacom.cinematica.models.entities.Room;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatDto {
    Long id;
    int row;
    int num;
    Room room;
    Date addDate;
    Date updateDate;
}
