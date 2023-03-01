package kg.megacom.cinematica.models.dtos;

import kg.megacom.cinematica.models.entities.Price;
import kg.megacom.cinematica.models.entities.RoomMovie;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomMoviePriceDto {
    Long id;
    RoomMovie roomMovie;
    Price price;
}
