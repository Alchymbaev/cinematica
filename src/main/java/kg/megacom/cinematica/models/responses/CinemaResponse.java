package kg.megacom.cinematica.models.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CinemaResponse {
    Long id;
    String name;
    Set<RoomResponse> rooms;
}
