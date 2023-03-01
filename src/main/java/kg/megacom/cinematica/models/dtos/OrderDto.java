package kg.megacom.cinematica.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    double price;
    Date addDate;
    Date updateDate;
}
