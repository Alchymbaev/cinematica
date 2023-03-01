package kg.megacom.cinematica.mappers;

import kg.megacom.cinematica.models.dtos.PriceDto;
import kg.megacom.cinematica.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper extends BaseMapper<Price, PriceDto>{
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
}
