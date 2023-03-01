package kg.megacom.cinematica.models.dtos;

import kg.megacom.cinematica.models.entities.RoomMovie;
import kg.megacom.cinematica.models.entities.Seat;
import kg.megacom.cinematica.models.enums.SeatStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatScheduleDto {
    Long id;
    Seat seat;
    RoomMovie roomMovie;
    SeatStatus status;
}
