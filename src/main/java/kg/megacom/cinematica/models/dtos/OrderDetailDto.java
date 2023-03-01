package kg.megacom.cinematica.models.dtos;

import kg.megacom.cinematica.models.entities.Order;
import kg.megacom.cinematica.models.entities.SeatSchedule;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailDto {
    Long id;
    SeatSchedule seatSchedule;
    Order order;
}
