package kg.megacom.cinematica.models.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailResponse {
    String movieName;
    String cinemaName;
    String roomName;
    Date date;
    List<SeatResponse> seatsResponse;
    double totalPrice;
}
