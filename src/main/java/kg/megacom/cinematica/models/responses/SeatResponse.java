package kg.megacom.cinematica.models.responses;

import kg.megacom.cinematica.models.enums.PriceTypeEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatResponse {
    Long id;
    int row;
    int num;
    PriceTypeEnum priceType;
    double price;
}
