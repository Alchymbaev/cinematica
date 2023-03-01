package kg.megacom.cinematica.models.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MovieResponse {
    Long id;
    String name;
    String image;
    int pg;

}
