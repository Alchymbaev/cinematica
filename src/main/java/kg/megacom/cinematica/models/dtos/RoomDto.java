package kg.megacom.cinematica.models.dtos;

import kg.megacom.cinematica.models.entities.Cinema;
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
public class RoomDto {
    Long id;
    String name;
    int seatCount;
    Cinema cinema;
    boolean isActive;
    Date addDate;
    Date updateDate;
}
