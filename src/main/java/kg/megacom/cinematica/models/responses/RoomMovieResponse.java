package kg.megacom.cinematica.models.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomMovieResponse {
    Long id;
    double standartPrice;
    double childPrice;
    LocalTime startTime;
}
