package kg.megacom.cinematica.models.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionsResponse {
    String name;
    String description;
    int pg;
    String image;
    Set<CinemaResponse> cinemas;
}
