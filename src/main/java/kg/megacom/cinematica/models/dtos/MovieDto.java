package kg.megacom.cinematica.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieDto {
    Long id;
    String name;
    int year;
    String description;
    String image;
    double rating;
    int pg;
    boolean isActive;
    Date addDate;
    Date updateDate;
}
