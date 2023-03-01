package kg.megacom.cinematica.models.responses;

import kg.megacom.cinematica.models.enums.SeatStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SeatScheduleResponse {
    Long id;
    SeatStatus status;
    int row;
    int num;
}
