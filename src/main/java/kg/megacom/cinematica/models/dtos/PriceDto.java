package kg.megacom.cinematica.models.dtos;

import kg.megacom.cinematica.models.enums.PriceTypeEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto {
    Long id;
    double price;
    PriceTypeEnum priceType;
    Date addDate;
    Date updateDate;
}
